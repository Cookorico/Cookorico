package fil.iagl.cookorico.dao;

import java.util.List;

import fil.iagl.cookorico.entity.Member;
import fil.iagl.cookorico.entity.Picture;

public interface PictureDao {
	
	List<Picture> getAllPictures();
	
	Picture getMemberPicture(Member member);

}
