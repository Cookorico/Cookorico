package fil.iagl.cookorico.controller;

import fil.iagl.cookorico.entity.Comment;
import fil.iagl.cookorico.entity.CurrentUser;
import fil.iagl.cookorico.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

	@Autowired
	CommentService commentService;
	
	@RequestMapping(value="/comments", method = RequestMethod.GET)
	public @ResponseBody List<Comment> getAllComments() {
		
		return commentService.getAllComments();
	}
	

	@RequestMapping(value="/comment/add", method = RequestMethod.POST)
	public @ResponseBody void addComment(@RequestBody Comment comment) {

        CurrentUser currentUser = (CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        comment.setMember(currentUser.getMember());
		commentService.addComment(comment);
		
	}
	
	
	@RequestMapping(value="/comments/recipe/{id}", method = RequestMethod.GET)
	public @ResponseBody List<Comment> getAllCommentsByIdRecipe(@PathVariable String id) {
		return commentService.getAllCommentsByIdRecipe(Integer.parseInt(id));
	}

		

	
}
