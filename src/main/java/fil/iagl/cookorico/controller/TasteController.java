package fil.iagl.cookorico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
		
		return tasteService.getAllTastes();
	}
}
