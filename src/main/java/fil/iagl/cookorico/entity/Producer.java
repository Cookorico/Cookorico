package fil.iagl.cookorico.entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import org.apache.ibatis.type.Alias;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

@JsonSerialize
@Data
@Alias("Producer")
public class Producer {

	private Integer idProducer;
	private String name;
	private String city;
	private String description;
	private List<Ingredient> ingredients;
//	private Timestamp creationDate;
//	private Timestamp modifDate;
//	private Boolean disabled;

}
