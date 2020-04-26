package fun.haarf.blog.service;

import fun.haarf.blog.entity.ArticleCategory;
import fun.haarf.blog.jpa.ArticleCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleCategoryService {

    @Autowired
    private ArticleCategoryRepository articleCategoryRepository;

    /**
     * find all articleCategory
     */
    public List<ArticleCategory> findAll() {
        return articleCategoryRepository.findAll();
    }

    /**
     * find all articleCategory pageable
     */
    public Page<ArticleCategory> findAll(Pageable pageable) {
        return articleCategoryRepository.findAll(pageable);
    }

    /**
     * find articleCategory by id
     */
    public ArticleCategory find(long id) {
        return articleCategoryRepository.findById(id).orElse(null);
    }

    /**
     * find all articleCategory by articleId
     */
    public List<ArticleCategory> findByArticleId(int articleId) {
        return articleCategoryRepository.findByArticleId(articleId);
    }

    /**
     * find all articleCategory pageable by articleId
     */
    public Page<ArticleCategory> findByArticleId(int articleId, Pageable pageable) {
        return articleCategoryRepository.findByArticleId(articleId, pageable);
    }

    /**
     * find all articleCategory by categoryId
     */
    public List<ArticleCategory> findByCategoryId(int categoryId) {
        return articleCategoryRepository.findByCategoryId(categoryId);
    }

    /**
     * find all articleCategory pageable by categoryId
     */
    public Page<ArticleCategory> findByCategoryId(int categoryId, Pageable pageable) {
        return articleCategoryRepository.findByCategoryId(categoryId, pageable);
    }

    /**
     * save articleCategory
     */
    public void save(ArticleCategory articleTag) {
        articleCategoryRepository.save(articleTag);
    }

    /**
     * delete articleCategory
     */
    public void delete(long id) {
        articleCategoryRepository.deleteById(id);
    }

    /**
     * delete articleCategory by article id
     */
    public void deleteByArticleId(int articleId) {
        articleCategoryRepository.deleteByArticleId(articleId);
    }

    /**
     * delete articleCategory by category id
     */
    public void deleteByCategoryId(int categoryId) {
        articleCategoryRepository.deleteByCategoryId(categoryId);
    }
}
