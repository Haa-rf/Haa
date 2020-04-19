package fun.haarf.blog.service;

import fun.haarf.blog.entity.Category;
import fun.haarf.blog.jpa.CategoryRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    /**
     * find all category
     */
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    /**
     * find all category pageable
     */
    public Page<Category> findAll(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    /**
     * find category by id
     */
    public Category find(int id) {
        return categoryRepository.findById(id).orElse(null);
    }

    /**
     * update category value by id
     */
    public void update(int id, String value) {
        Category fundCategory = categoryRepository.findById(id).orElse(null);
        if (fundCategory != null&&StringUtils.isNotBlank(value)) {
            fundCategory.setValue(value);
            categoryRepository.save(fundCategory);
        }
    }

    /**
     * save category
     */
    public void save(String value) {
        Category fundCategory = categoryRepository.findByValue(value);
        if (fundCategory == null) {
            Category category = new Category();
            category.setValue(value);
            categoryRepository.save(category);
        }
    }

    /**
     * delete category
     */
    public void delete(int id) {
        categoryRepository.deleteById(id);
    }
}
