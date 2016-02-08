package fil.iagl.cookorico.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import fil.iagl.cookorico.entity.Comment;
import fil.iagl.cookorico.entity.Member;

public interface CommentDao {

	List<Comment> getAllComments();
	
	List<Comment> getAllCommentsByIdRecipe(int id);
	
	List<Comment> getCommentsRecipeByMember(int idMember, int idRecipe);
	
	void addComment(Map<String, String> parms);
	
}
