package fil.iagl.cookorico.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;
import lombok.EqualsAndHashCode;

@JsonSerialize
@Data
@EqualsAndHashCode(callSuper=false)
public class Administrator extends Member{

	private Integer id;
	private String adminRank; //TO DO ENUM
}
