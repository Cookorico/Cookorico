package fil.iagl.cookorico.controller;

import fil.iagl.cookorico.entity.Picture;
import fil.iagl.cookorico.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/picture")
public class PictureController {

    @Autowired
    private PictureService imageService;

    @RequestMapping(method = RequestMethod.POST)
    public Picture upload(@RequestParam(value = "file") MultipartFile multipartFile) {
        return this.imageService.savePicture(multipartFile);
    }

    @RequestMapping(value = "/recipe/{id} ", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Picture> getPicturesByRecipeId(@PathVariable("id") Integer recipeId) {
        return imageService.getPictureByRecipeId(recipeId);
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
