package fil.iagl.cookorico.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fil.iagl.cookorico.dao.RecipeStepDao;
import fil.iagl.cookorico.entity.RecipeStep;
import fil.iagl.cookorico.service.RecipeStepService;

@Service
public class RecipeStepServiceImpl implements RecipeStepService{
	
	@Autowired
	private RecipeStepDao recipeStepDao;
	
	@Override
	public RecipeStep getRecipeStepById(int id) {
		return recipeStepDao.getRecipeStepById(id);
	}

	@Override
	public List<RecipeStep> getRecipeStepByIdRecipe(int id) {
		return recipeStepDao.getRecipeStepByIdRecipe(id);
	}

	@Override
	public void addRecipeStep(RecipeStep recipeStep) {
		recipeStepDao.addRecipeStep(recipeStep);
	}

}
