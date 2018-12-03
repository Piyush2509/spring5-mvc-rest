package guru.springframework.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import guru.springframework.domain.Category;

/**
 * Created by piyush.b.kumar on Jul 18, 2018
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {

	Category findByName(String string);

}
