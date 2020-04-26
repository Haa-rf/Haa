package fun.haarf.blog.service;

import fun.haarf.blog.entity.ArticleInfo;
import fun.haarf.blog.jpa.ArticleInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleInfoService {

    @Autowired
    private ArticleInfoRepository articleInfoRepository;

    /**
     * find all article info
     */
    public List<ArticleInfo> findAll() {
        return articleInfoRepository.findAll();
    }

    /**
     * find all article info pageable
     */
    public Page<ArticleInfo> findAll(Pageable pageable) {
        return articleInfoRepository.findAll(pageable);
    }

    /**
     * find article info by id
     */
    public ArticleInfo find(int id) {
        return articleInfoRepository.findById(id).orElse(null);
    }

    /**
     * find article info by id
     */
    public ArticleInfo findByArticleId(int articleId) {
        return articleInfoRepository.findByArticleId(articleId);
    }

    /**
     * update article info value by article id
     */
    public void update(int articleId, int read, int like) {
        ArticleInfo fundArticleInfo = articleInfoRepository.findByArticleId(articleId);
        if (fundArticleInfo != null) {
            fundArticleInfo.setReadNumber(read);
            fundArticleInfo.setLikeNumber(like);
            articleInfoRepository.save(fundArticleInfo);
        }
    }

    /**
     * save article info
     */
    public void save(int articleId, int read, int like) {
        ArticleInfo fundArticleInfo = articleInfoRepository.findByArticleId(articleId);
        if (fundArticleInfo == null) {
            ArticleInfo articleInfo = new ArticleInfo();
            articleInfo.setArticleId(articleId);
            articleInfo.setReadNumber(read);
            articleInfo.setLikeNumber(like);
            articleInfoRepository.save(articleInfo);
        }
    }

    /**
     * delete article info
     */
    public void delete(int id) {
        articleInfoRepository.deleteById(id);
    }

    /**
     * delete article info by article id
     */
    public void deleteByArticleId(int articleId) {
        articleInfoRepository.deleteByArticleId(articleId);
    }
}
