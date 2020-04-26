package fun.haarf.blog.jpa;

import fun.haarf.blog.entity.ArticleLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleLogRepository extends JpaRepository<ArticleLog, Long> {

    List<ArticleLog> findByUsername(String username);

    Page<ArticleLog> findByUsername(String username, Pageable pageable);

    List<ArticleLog> findByIp(String ip);

    Page<ArticleLog> findByIp(String ip, Pageable pageable);

    void deleteAllByUsername(String username);
}
