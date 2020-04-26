package fun.haarf.blog.service;

import fun.haarf.blog.entity.ArticleTag;
import fun.haarf.blog.jpa.ArticleTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleTagService {

    @Autowired
    private ArticleTagRepository articleTagRepository;

    /**
     * find all articleTag
     */
    public List<ArticleTag> findAll() {
        return articleTagRepository.findAll();
    }

    /**
     * find all articleTag pageable
     */
    public Page<ArticleTag> findAll(Pageable pageable) {
        return articleTagRepository.findAll(pageable);
    }

    /**
     * find articleTag by id
     */
    public ArticleTag find(long id) {
        return articleTagRepository.findById(id).orElse(null);
    }

    /**
     * find all articleTag by articleId
     */
    public List<ArticleTag> findByArticleId(int articleId) {
        return articleTagRepository.findByArticleId(articleId);
    }

    /**
     * find all articleTag pageable by articleId
     */
    public Page<ArticleTag> findByArticleId(int articleId, Pageable pageable) {
        return articleTagRepository.findByArticleId(articleId, pageable);
    }

    /**
     * find all articleTag by tagId
     */
    public List<ArticleTag> findByTagId(int tagId) {
        return articleTagRepository.findByTagId(tagId);
    }

    /**
     * find all articleTag pageable by tagId
     */
    public Page<ArticleTag> findByTagId(int tagId, Pageable pageable) {
        return articleTagRepository.findByTagId(tagId, pageable);
    }

    /**
     * save articleTag
     */
    public void save(ArticleTag articleTag) {
        articleTagRepository.save(articleTag);
    }

    /**
     * delete articleTag
     */
    public void delete(long id) {
        articleTagRepository.deleteById(id);
    }

    /**
     * delete articleTag by article id
     */
    public void deleteByArticleId(int articleId) {
        articleTagRepository.deleteByArticleId(articleId);
    }

    /**
     * delete articleTag by tag id
     */
    public void deleteByTagId(int tagId) {
        articleTagRepository.deleteByTagId(tagId);
    }
}
