package fil.iagl.cookorico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fil.iagl.cookorico.entity.CurrentUser;
import fil.iagl.cookorico.entity.Ingredient;
import fil.iagl.cookorico.entity.Taste;
import fil.iagl.cookorico.service.TasteService;

@RestController
public class TasteController {

	@Autowired
	TasteService tasteService;
	
	@RequestMapping(value="/taste/{id}", method = RequestMethod.GET)
	public @ResponseBody List<Taste> getTastesByMember(@PathVariable String id) {
		
		return tasteService.getTastesByMember(Integer.parseInt(id));
	}
	
	@RequestMapping(value="/tastes", method = RequestMethod.GET)
	public @ResponseBody List<Taste> getTastes() {
		CurrentUser currentUser = (CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return tasteService.getTastesByMember(currentUser.getId());
	}
	
	@RequestMapping(value="/taste", method = RequestMethod.POST)
	public void addTaste(@RequestBody ModelMap model){
		CurrentUser currentUser = (CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int idIngredient = Integer.valueOf(String.valueOf(model.get("idIngredient")));
		int grading =  Integer.valueOf(String.valueOf(model.get("grading")));
		Taste taste = new Taste();
		taste.setMember(currentUser.getMember());
		taste.setIngredient(new Ingredient(idIngredient));
		taste.setGrading(grading);
		tasteService.addTaste(taste);		
	}
	
	@RequestMapping(value="/taste", method = RequestMethod.PUT)
	public void updateTaste(@RequestBody ModelMap model){
		CurrentUser currentUser = (CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int idIngredient = Integer.valueOf(String.valueOf(model.get("idIngredient")));
		int grading =  Integer.valueOf(String.valueOf(model.get("grading")));
		Taste taste = new Taste();
		taste.setMember(currentUser.getMember());
		taste.setIngredient(new Ingredient(idIngredient));
		taste.setGrading(grading);
		tasteService.updateTaste(taste);
	}
}
