package fil.iagl.cookorico.entity;

import java.sql.Timestamp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

@JsonSerialize
@Data
public class Taste {
	
	private int idTaste;
	private Member member;
	private Ingredient ingredient;
	private int grading;
	private Timestamp creationDate;
	private Timestamp modifDate;

}
