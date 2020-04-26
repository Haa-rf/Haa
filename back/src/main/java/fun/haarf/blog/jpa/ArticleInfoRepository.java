package fun.haarf.blog.jpa;

import fun.haarf.blog.entity.ArticleInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleInfoRepository extends JpaRepository<ArticleInfo, Integer> {
    ArticleInfo findByArticleId(int id);

    void deleteByArticleId(int articleId);
}
