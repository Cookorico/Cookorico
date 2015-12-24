package fil.iagl.cookorico.entity;

import java.sql.Timestamp;

//import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

@JsonSerialize
@Data
//@Alias("Picture")
public class Picture {
	
	private Integer idPicture;
	private Member member;
	private String filePath;
	private String fileName;
	private String title;
	private String description;
	private Timestamp creationDate;
	private Boolean disabled;

}
