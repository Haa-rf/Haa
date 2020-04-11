package fun.haarf.blog.jpa;

import fun.haarf.blog.entity.ArticleLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleLogRepository extends JpaRepository<ArticleLog, Long> {
}
