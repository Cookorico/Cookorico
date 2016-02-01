package fil.iagl.cookorico.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping(value="/comments/recipe/{id}", method = RequestMethod.GET)
	public @ResponseBody List<Comment> getAllCommentsByIdRecipe(@PathVariable String id) {
		return commentService.getAllCommentsByIdRecipe(Integer.parseInt(id));
	}
	
	
	@RequestMapping(value="/addComment/{idRecipe}/{idMember}/{title}/{description}", method = RequestMethod.GET)
	public @ResponseBody void addComment(@PathVariable String idRecipe, @PathVariable String idMember, @PathVariable String title, @PathVariable String description) {
		
		Map<String, String> parms = new HashMap<String, String>();
		parms.put("idRecipe", idRecipe);
		parms.put("idMember", idMember);
		parms.put("title", title);
		parms.put("description", description);
		
		commentService.addComment(parms);
		
	}
	
}
