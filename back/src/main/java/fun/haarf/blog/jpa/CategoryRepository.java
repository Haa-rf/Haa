package fun.haarf.blog.jpa;

import fun.haarf.blog.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category findByValue(String value);
}
