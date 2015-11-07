package fil.iagl.cookorico.entity;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;
import lombok.EqualsAndHashCode;

@JsonSerialize
@Data
@EqualsAndHashCode(callSuper=false)
@Alias("Administrator")
public class Administrator extends Member{

	private Integer idAdministrator;
	private String adminRank; //TO DO ENUM
}
