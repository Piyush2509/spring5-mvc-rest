package guru.springframework.api.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * Created by piyush.b.kumar on Jul 19, 2018
 */
@Data
public class CustomerDTO {

	private String firstname;
	private String lastname;
	@JsonProperty("customer_url")
	private String customerUrl;

}
