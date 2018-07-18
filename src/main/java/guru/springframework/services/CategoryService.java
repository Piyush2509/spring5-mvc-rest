package guru.springframework.services;

import java.util.List;

import guru.springframework.api.v1.model.CategoryDTO;

/**
 * Created by piyush.b.kumar on Jul 18, 2018
 */
public interface CategoryService {

	List<CategoryDTO> getAllCategories();

	CategoryDTO getCategoryByName(String name);

}
