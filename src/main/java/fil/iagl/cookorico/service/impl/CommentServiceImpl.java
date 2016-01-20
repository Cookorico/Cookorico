package fil.iagl.cookorico.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fil.iagl.cookorico.dao.CommentDao;
import fil.iagl.cookorico.entity.Comment;
import fil.iagl.cookorico.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	private CommentDao commentDao;
	
	@Override
	public List<Comment> getAllComments() {
		System.out.println("*****************************");
		return commentDao.getAllComments();
	}

	@Override
	public void addComment(Map<String, String> parms) {
		System.out.println("add comment");
		commentDao.addComment(parms);
	}
}
