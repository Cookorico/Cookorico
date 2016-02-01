package fil.iagl.cookorico.service.impl;

import fil.iagl.cookorico.dao.RecipeStepSuccessfulDao;
import fil.iagl.cookorico.service.ProgressionService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by leemans on 26/01/16.
 */
public class ProgressionServiceImpl implements ProgressionService {

    @Autowired
    RecipeStepSuccessfulDao recipeStepSuccessfulDao;

    @Override
    public void addRecipeStepSuccessfulDao(Integer recipeStepId, Integer memberId) {
        recipeStepSuccessfulDao.addRecipeStepSuccessfulDao(recipeStepId, memberId);
    }

}
