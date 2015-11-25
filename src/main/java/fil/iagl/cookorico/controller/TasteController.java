package fil.iagl.cookorico.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fil.iagl.cookorico.entity.Taste;
import fil.iagl.cookorico.service.TasteService;

@RestController
public class TasteController {

	TasteService tasteService;
	
	@RequestMapping(value="/taste/{id}", method = RequestMethod.GET)
	public @ResponseBody List<Taste> getTastesByMember(@PathVariable String id) {
		
		System.out.println("**************"+Integer.parseInt(id));
		return tasteService.getTastesByMember(Integer.parseInt(id));
	}
}
