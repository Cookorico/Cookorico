package fil.iagl.cookorico.service;

import java.util.List;

import fil.iagl.cookorico.entity.Comment;

public interface CommentService {

	List<Comment> getAllComments();

	List<Comment> getAllCommentsByIdRecipe(int id);
	
	void addComment(Comment comment);
}
