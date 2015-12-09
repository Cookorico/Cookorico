package fil.iagl.cookorico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fil.iagl.cookorico.entity.Comment;
import fil.iagl.cookorico.service.CommentService;

@RestController
public class CommentController {

	@Autowired
	CommentService commentService;
	
	@RequestMapping(value="/comments", method = RequestMethod.GET)
	public @ResponseBody List<Comment> getAllComments() {
		
		return commentService.getAllComments();
		
	}
}
