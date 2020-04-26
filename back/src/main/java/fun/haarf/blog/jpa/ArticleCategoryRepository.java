package fun.haarf.blog.jpa;

import fun.haarf.blog.entity.ArticleCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleCategoryRepository extends JpaRepository<ArticleCategory, Long> {

    List<ArticleCategory> findByArticleId(int articleId);

    Page<ArticleCategory> findByArticleId(int articleId, Pageable pageable);

    List<ArticleCategory> findByCategoryId(int categoryId);

    Page<ArticleCategory> findByCategoryId(int categoryId, Pageable pageable);

    void deleteByArticleId(int articleId);

    void deleteByCategoryId(int categoryId);
}
