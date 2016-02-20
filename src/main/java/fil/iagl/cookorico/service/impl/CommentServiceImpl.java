package fil.iagl.cookorico.service.impl;

import fil.iagl.cookorico.dao.CommentDao;
import fil.iagl.cookorico.entity.Comment;
import fil.iagl.cookorico.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	private CommentDao commentDao;
	
	@Override
	public List<Comment> getAllComments() {
		return commentDao.getAllComments();
	}

	@Override
	public List<Comment> getAllCommentsByIdRecipe(int id) {
		return commentDao.getAllCommentsByIdRecipe(id);
	}

	@Override
	public void addComment(Comment comment) {
		commentDao.addComment(comment);
		
	}

}
