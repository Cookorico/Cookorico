package fil.iagl.cookorico.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import fil.iagl.cookorico.entity.Comment;

public interface CommentDao {

	List<Comment> getAllComments();
	
	List<Comment> getAllCommentsByIdRecipe(int id);
	
	List<Comment> getCommentsRecipeByMember(int idMember, int idRecipe);
	
	void addComment(@Param("comment") Comment comment);
	
}
