package pl.firmy90.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.firmy90.model.domain.entity.Category;

public interface CategoryRepository extends JpaRepository<Category,Long> {

}
