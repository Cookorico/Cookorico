package fil.iagl.cookorico.entity;

import java.sql.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

@JsonSerialize
@Data
public class Ingredient {

	private Integer id;
	private String name;
	private String description;
	private Date creationDate;
	private Date modifDate;
	private Boolean validation;
	private Boolean disabled;

}
