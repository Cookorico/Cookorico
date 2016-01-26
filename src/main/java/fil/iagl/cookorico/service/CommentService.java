package fil.iagl.cookorico.service;

import java.util.List;
import java.util.Map;

import fil.iagl.cookorico.entity.Comment;

public interface CommentService {

	List<Comment> getAllComments();
	
	void addComment(Map<String, String> parms);
}
