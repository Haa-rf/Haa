package fun.haarf.blog.service;

import fun.haarf.blog.entity.Tag;
import fun.haarf.blog.jpa.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    /**
     * find all tags
     */
    public List<Tag> findAll() {
        return tagRepository.findAll();
    }

    /**
     * find all tags pageable
     */
    public Page<Tag> findAll(Pageable pageable) {
        return tagRepository.findAll(pageable);
    }

    /**
     * find tag by id
     */
    public Tag find(int id) {
        return tagRepository.findById(id).orElse(null);
    }

    /**
     * find tag by value
     */
    public Tag find(String value) {
        return tagRepository.findByValue(value);
    }

    /**
     * update tag value by id
     */
    public void update(int id, String value) {
        Tag fundTag = tagRepository.findById(id).orElse(null);
        if (fundTag != null) {
            fundTag.setValue(value);
            tagRepository.save(fundTag);
        }
    }

    /**
     * save tag
     */
    public void save(String value) {
        Tag fundTag = tagRepository.findByValue(value);
        if (fundTag == null) {
            Tag tag = new Tag();
            tag.setValue(value);
            tagRepository.save(tag);
        }
    }

    /**
     * delete tag
     */
    public void delete(int id) {
        tagRepository.deleteById(id);
    }
}
