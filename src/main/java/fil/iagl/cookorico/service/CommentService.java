package fil.iagl.cookorico.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import fil.iagl.cookorico.entity.Comment;
import fil.iagl.cookorico.entity.Producer;

public interface CommentService {

	List<Comment> getAllComments();

	List<Comment> getAllCommentsByIdRecipe(int id);
	
	void addComment(Comment comment);
}
