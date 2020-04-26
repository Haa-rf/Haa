package fun.haarf.blog.jpa;

import fun.haarf.blog.entity.ArticleTag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleTagRepository extends JpaRepository<ArticleTag, Long> {
    List<ArticleTag> findByArticleId(int articleId);

    Page<ArticleTag> findByArticleId(int articleId, Pageable pageable);

    List<ArticleTag> findByTagId(int tagId);

    Page<ArticleTag> findByTagId(int tagId, Pageable pageable);

    void deleteByArticleId(int articleId);

    void deleteByTagId(int tagId);
}
