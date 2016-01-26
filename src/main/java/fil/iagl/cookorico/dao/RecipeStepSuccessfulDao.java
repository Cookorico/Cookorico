package fil.iagl.cookorico.dao;

import fil.iagl.cookorico.entity.Member;
import fil.iagl.cookorico.entity.RecipeStep;
import org.apache.ibatis.annotations.Param;

/**
 * Created by leemans on 26/01/16.
 */
public interface RecipeStepSuccessfulDao {

    void addRecipeStepSuccessfulDao(@Param("id_recipieStep") Integer recipeStepId, @Param("id_member")Integer memberId);

}
