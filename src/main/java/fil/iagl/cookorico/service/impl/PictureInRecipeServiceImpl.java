package fil.iagl.cookorico.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fil.iagl.cookorico.dao.PictureInRecipeDao;
import fil.iagl.cookorico.entity.PictureInRecipe;
import fil.iagl.cookorico.service.PictureInRecipeService;

@Service
public class PictureInRecipeServiceImpl implements PictureInRecipeService {

    @Autowired
    private PictureInRecipeDao pictureInRecipeDao;

	@Override
	public void associatePictureWithRecipe(PictureInRecipe pictureInRecipe) {
		this.pictureInRecipeDao.associatePictureWithRecipe(pictureInRecipe);
	}

	@Override
	public void deleteByPictureId(Integer idPicture) {
		this.pictureInRecipeDao.deleteByPictureId(idPicture);
	}

	@Override
	public void deleteByRecipeId(Integer idRecipe) {
		this.pictureInRecipeDao.deleteByRecipeId(idRecipe);
	}
}