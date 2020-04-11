package fun.haarf.blog.jpa;

import fun.haarf.blog.entity.ArticleCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleCategoryRepository extends JpaRepository<ArticleCategory, Long> {
}
