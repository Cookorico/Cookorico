package fil.iagl.cookorico.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fil.iagl.cookorico.entity.Comment;
import fil.iagl.cookorico.entity.Member;
import fil.iagl.cookorico.entity.Recipe;
import fil.iagl.cookorico.service.CommentService;

@RestController
public class CommentController {

	@Autowired
	CommentService commentService;
	
	@RequestMapping(value="/comments", method = RequestMethod.GET)
	public @ResponseBody List<Comment> getAllComments() {
		
		return commentService.getAllComments();
	}
	

	
	/**
	 * A refaire
	 * @param idRecipe
	 * @param idMember
	 * @param title
	 * @param description
	 */
	@RequestMapping(value="/comment/add", method = RequestMethod.POST)
	public @ResponseBody void addComment(@RequestBody ModelMap model) {
		
		int idRecipe = Integer.valueOf(String.valueOf(model.get("cmt_fk_id_recipe")));
		int idMember = Integer.valueOf(String.valueOf(model.get("cmt_fk_id_member")));
		String title = String.valueOf(String.valueOf(model.get("cmt_title")));
		String description = String.valueOf(String.valueOf(model.get("cmt_description")));
		Date date = new Date();
		Timestamp creationDate = new Timestamp(date.getTime());
		
		Comment comment = new Comment();
		
		comment.setRecipe(new Recipe(idRecipe));
		comment.setMember(new Member());
		comment.setTitle(title);
		comment.setDescription(description);
		comment.setCreationDate(creationDate);
		commentService.addComment(comment);
		
	}
	
	
	@RequestMapping(value="/comments/recipe/{id}", method = RequestMethod.GET)
	public @ResponseBody List<Comment> getAllCommentsByIdRecipe(@PathVariable String id) {
		return commentService.getAllCommentsByIdRecipe(Integer.parseInt(id));
	}

		

	
}
