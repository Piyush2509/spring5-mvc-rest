package guru.springframework.api.v1.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by piyush.b.kumar on Jul 18, 2018
 */
@Data
public class CategoryDTO {

	private Long id;
	@ApiModelProperty(value = "Category Name")
	private String name;

}
