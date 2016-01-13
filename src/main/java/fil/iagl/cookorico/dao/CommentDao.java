package fil.iagl.cookorico.dao;

import java.util.List;

import fil.iagl.cookorico.entity.Comment;

public interface CommentDao {

	List<Comment> getAllComments();
	
	List<Comment> getCommentsRecipeByMember(int idMember, int idRecipe);
	
}
