package fil.iagl.cookorico.entity;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

@JsonSerialize
@Data
@Alias("Taste")
public class Taste {
	
	private Integer idTaste;
	private Member member;
	private Ingredient ingredient;
	private Integer grading;
	private Timestamp creationDate;
	private Timestamp modifDate;

}
