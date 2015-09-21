package fil.iagl.cookorico.entity;

import java.sql.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

@JsonSerialize
@Data
public class Photo {

	private Integer id;
	private Integer idMember;
	private String filePath;
	private String fileName;
	private String title;
	private String description;
	private Date creationDate;
	private Boolean disabled;

}
