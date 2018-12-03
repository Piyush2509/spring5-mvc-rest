package guru.springframework.api.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by piyush.b.kumar on Jul 19, 2018
 */
@Data
public class CustomerDTO {

	@ApiModelProperty(value = "Customer First Name", required = true)
	private String firstname;
	@ApiModelProperty(value = "Customer Last Name", required = true)
	private String lastname;
	@JsonProperty("customer_url")
	private String customerUrl;

}
