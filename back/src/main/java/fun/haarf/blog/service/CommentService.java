package fun.haarf.blog.service;

import fun.haarf.blog.entity.Comment;
import fun.haarf.blog.jpa.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    /**
     * find all comment
     */
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    /**
     * find all comment pageable
     */
    public Page<Comment> findAll(Pageable pageable) {
        return commentRepository.findAll(pageable);
    }

    /**
     * find comment by article id
     */
    public List<Comment> find(int articleId) {
        return commentRepository.findByArticleId(articleId);
    }

    /**
     * update or save comment value by id
     */
    public void updateOrSave(Comment comment) {
        commentRepository.save(comment);
    }

    /**
     * delete comment
     */
    public void delete(long id) {
        commentRepository.deleteById(id);
    }
}
