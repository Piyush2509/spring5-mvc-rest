package guru.springframework.api.v1.mapper;

import static org.junit.Assert.*;

import org.junit.Test;

import guru.springframework.api.v1.model.CategoryDTO;
import guru.springframework.domain.Category;

/**
 * Created by piyush.b.kumar on Jul 18, 2018
 */
public class CategoryMapperTest {

	private static final String NAME = "Joe";
	private static final long ID = 1L;

	CategoryMapper categoryMapper = CategoryMapper.INSTANCE;

	@Test
	public void categoryTpCategoryDTO() {
		// given
		Category category = new Category();
		category.setName(NAME);
		category.setId(ID);

		// when
		CategoryDTO categoryDTO = categoryMapper.categoryToCategoryDTO(category);

		// then
		assertEquals(Long.valueOf(ID), categoryDTO.getId());
		assertEquals(NAME, categoryDTO.getName());
	}

}
