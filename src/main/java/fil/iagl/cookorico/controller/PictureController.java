package fil.iagl.cookorico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import fil.iagl.cookorico.entity.Picture;
import fil.iagl.cookorico.service.PictureService;

@RestController
@RequestMapping("/picture")
public class PictureController {

	@Autowired
	private PictureService imageService;
	
	@RequestMapping(method = RequestMethod.POST)
	public Picture upload(@RequestParam(value = "file") MultipartFile multipartFile) {
		return this.imageService.savePicture(multipartFile);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public void delete(@RequestBody Picture picture) {
		this.imageService.delete(picture);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Picture getPictureById(@PathVariable("id") Integer id) {
		return this.imageService.getPictureById(id);
	}
}
