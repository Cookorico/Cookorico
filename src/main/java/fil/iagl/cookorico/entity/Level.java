package fil.iagl.cookorico.entity;



import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data; 

@JsonSerialize
@Data
@Alias("Level")
public class Level {
	
	private Integer idLevel;
	private Integer levelNum;
	private Integer levelPic;
	private String labelLvl;
	private Integer xpMin;
	private Integer xpMax;

}
