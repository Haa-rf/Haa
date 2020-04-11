package fun.haarf.blog.jpa;

import fun.haarf.blog.entity.ArticleTag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleTagRepository extends JpaRepository<ArticleTag, Long> {
}
