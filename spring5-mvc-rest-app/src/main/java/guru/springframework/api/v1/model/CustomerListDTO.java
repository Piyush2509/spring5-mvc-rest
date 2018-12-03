package guru.springframework.api.v1.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by piyush.b.kumar on Jul 19, 2018
 */
@Data
@AllArgsConstructor
public class CustomerListDTO {

	List<CustomerDTO> customers;

}
