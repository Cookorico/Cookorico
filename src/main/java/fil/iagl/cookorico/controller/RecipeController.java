package fil.iagl.cookorico.controller;

import fil.iagl.cookorico.entity.*;
import fil.iagl.cookorico.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
public class RecipeController {


    @Autowired
    private RecipeService recipeService;

    @Autowired
    private IngredientInRecipeService ingredientInRecipeService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private RecipeStepService recipeStepService;

    @Autowired
    AdministratorService administratorService;

    /**
     * Recherche une recette par son id
     *
     * @param id L'id de la recette
     * @return La recette trouvée
     */
    @RequestMapping(value = "/recipe/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    Recipe getRecipe(@PathVariable String id) {
        return recipeService.getRecipeById(Integer.parseInt(id));
    }

    /**
     * Recupère nb recettes au hasard
     *
     * @param nb le nombre de recette voulue
     * @return la liste des recettes séléctionnées
     */
    @RequestMapping(value = "/recipeUne/{nb}", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Recipe> getRandomRecipe(@PathVariable String nb) {
        return recipeService.getRandomRecipes(Integer.parseInt(nb));

    }

    /**
     * Ajout en vitesse le 02/12, nom à check, utilisé dans recipectrl.
     *
     * @param id Id de la recette
     * @return True si le user courrent est le créateur de la recette
     */
    @RequestMapping(value = "/recipe/{id}/currentUserIsCreator", method = RequestMethod.GET)
    public
    @ResponseBody
    Boolean currentUserIsCreator(@PathVariable String id) {

        Recipe recipe = recipeService.getRecipeById(Integer.parseInt(id));
        CurrentUser currentUser = (CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Member m = currentUser.getMember();

        return m.getIdMember() == recipe.getCreator().getIdMember();
    }

    /**
     * Recuperation des recettes
     *
     * @param mainpic Si à true alors on recupère aussi les photos de la recette
     * @param tags    Si à true alors on recupère aussi les tags de la recette
     * @return liste des recettes trouvées
     */
    @RequestMapping(value = "/recipes", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Recipe> getListRecipe(@RequestParam(value = "mainpic", required = false) boolean mainpic, @RequestParam(value = "tags", required = false) boolean tags) {
        return recipeService.getAllRecipes(mainpic, tags);
    }

    /**
     * Recuperation des recettes
     *
     * @return liste des recettes trouvées
     */
    @RequestMapping(value = "/myrecipes", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Recipe> getListRecipeByUserId() {

        CurrentUser currentUser = (CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Member m = currentUser.getMember();
        int id = m.getIdMember();
        return recipeService.getAllRecipesByUserId(id);
    }

    /**
     * Ajout recette dans la BDD
     *
     * @param recipe Recette a ajouter
     * @return Recette créée
     */
    @RequestMapping(value = "/recipe/add", method = RequestMethod.POST)
    public
    @ResponseBody
    Recipe addRecipe(@RequestBody Recipe recipe) {

        CurrentUser currentUser = (CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        recipe.setCreator(currentUser.getMember());

        Timestamp creationDate = new Timestamp(new Date().getTime());
        recipe.setCreationDate(creationDate);

        recipe.setExperienceVal(recipe.getDifficulty() * 10);
        this.recipeService.addRecipe(recipe);

        // Workaround to delete
        Recipe dummyRecipe = new Recipe();
        dummyRecipe.setIdRecipe(recipe.getIdRecipe());

        for (IngredientInRecipe i : recipe.getIngredients()) {
            i.setRecipe(dummyRecipe);
            ingredientInRecipeService.addIngredientInRecipe(i);
        }

        for (RecipeStep recipeStep : recipe.getSteps()) {
            recipeStep.setRecipe(dummyRecipe);
            recipeStep.setDurationTime(0);
            recipeStepService.addRecipeStep(recipeStep);
        }

//
//		/* ajoute les ingredients à la recette */
//        List<LinkedHashMap> ingredientsReciped = (List<LinkedHashMap>) model.get("ingredients");
//        List<IngredientInRecipe> ingredients = new ArrayList<IngredientInRecipe>();
//        for (LinkedHashMap ingredient_in_recipe : ingredientsReciped) {
//            LinkedHashMap ingredient = (LinkedHashMap) ingredient_in_recipe.get("ingredient");
//            int idIng = (int) ingredient.get("idIngredient");
//            int quantity = (int) ingredient_in_recipe.get("quantity");
//            String unit_of_measure = (String) ingredient_in_recipe.get("measurement");
//            Ingredient ing = new Ingredient(idIng);
//            IngredientInRecipe ingrInRecipe = new IngredientInRecipe();
//            ingrInRecipe.setIngredient(ing);
//            ingrInRecipe.setQuantity(quantity);
//            ingrInRecipe.setUnitOfMeasurement(unit_of_measure);
//            ingredients.add(ingrInRecipe);
//
//        }
//
//        // get form data
//        int preparationTime = Integer.valueOf(String.valueOf(model.get("rcp_preparation_time")));
//        int cookingTime = Integer.valueOf(String.valueOf(model.get("rcp_cooking_time")));
//        int difficulty = Integer.valueOf(String.valueOf(model.get("rcp_difficulty")));
//        int experienceVal = Integer.valueOf(String.valueOf(model.get("rcp_experienceVal")));
//        String description = String.valueOf(model.get("rcp_description"));
//        String name = String.valueOf(model.get("rcp_name"));
//        String dish_type = String.valueOf(model.get("rcp_dish_type")); // TODO : vérifier valeur dans l'enum
//        //int mainPictureId = Integer.valueOf(String.valueOf(model.get("mainPictureId")));
//
//
//        // create recipe object
//        Recipe recipe = new Recipe();
//        recipe.setName(name);
//        recipe.setDescription(description);
//        recipe.setPreparationTime(preparationTime);
//        recipe.setCookingTime(cookingTime);
//        recipe.setCreator(creator);
//        recipe.setDishType(dish_type);
//        recipe.setDifficulty(difficulty);
//        recipe.setDraft(false); // TODO : valeur par défaut ?
//        //recipe.setMainPicture(this.pictureServive.getPictureById(mainPictureId)); // TODO : verifier mapper Picture pour getPictureById
//        recipe.setCreationDate(creationDate);
//        recipe.setModifDate(creationDate);
//        recipe.setValidation(false);
//        // TODO : recipe.SetValidator(integer)
//        recipe.setDisabled(false);
//        recipe.setExperienceVal(experienceVal); // TODO : à automatiser
//
//        recipe.setIngredients(ingredients);
//
//
//        // save the recipe to db
//
//        //if well done, add ingredients in recipe to db
//        for (IngredientInRecipe ingredient : recipe.getIngredients()) {
//            ingredient.setRecipe(new Recipe(recipe.getIdRecipe()));
//            this.ingredientInRecipeService.addIngredientInRecipe(ingredient);
//            ingredient.getIngredient().getIdIngredient();
//        }

        return recipe;
    }
}
