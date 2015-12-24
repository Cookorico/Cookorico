package fil.iagl.cookorico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fil.iagl.cookorico.controller.util.DataReturn;
import fil.iagl.cookorico.entity.Picture;
import fil.iagl.cookorico.service.PictureService;

@RestController
@RequestMapping("/picture")
public class PictureController {

	@Autowired
	private PictureService imageService;
	
	@RequestMapping(method = RequestMethod.POST)
	public DataReturn<Picture> upload(@RequestParam(value = "file") MultipartFile multipartFile) {
		return new DataReturn<>(imageService.savePicture(multipartFile));
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public DataReturn<Picture> getPictureById(@PathVariable("id") Integer id) {
		return new DataReturn<>(imageService.getPictureById(id));
	}
}
