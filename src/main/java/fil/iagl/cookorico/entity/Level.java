package fil.iagl.cookorico.entity;



import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data; 

@JsonSerialize
@Data
@Alias("Level")
public class Level {
	
	private Integer idLevel;
	private Integer level_num;
	private Integer level_pic;
	private String label_lvl;
	private Integer xp_min;
	private Integer xp_max;

}
