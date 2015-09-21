package fil.iagl.cookorico.dao;

import java.util.List;

import fil.iagl.cookorico.entity.Member;
import fil.iagl.cookorico.entity.Photo;

public interface PhotoDao {
	
	List<Photo> getAllPhotos();
	
	Photo getMemberPhoto(Member member);

}
