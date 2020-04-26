package fun.haarf.blog.service;

import fun.haarf.blog.entity.ArticleLog;
import fun.haarf.blog.jpa.ArticleLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleLogService {

    @Autowired
    private ArticleLogRepository articleLogRepository;

    /**
     * find all article log
     */
    public List<ArticleLog> findAll() {
        return articleLogRepository.findAll();
    }

    /**
     * find all article log pageable
     */
    public Page<ArticleLog> findAll(Pageable pageable) {
        return articleLogRepository.findAll(pageable);
    }

    /**
     * find article log by id
     */
    public ArticleLog find(long id) {
        return articleLogRepository.findById(id).orElse(null);
    }

    /**
     * find all article log by username
     */
    public List<ArticleLog> findAllByUsername(String username) {
        return articleLogRepository.findByUsername(username);
    }

    /**
     * find all article log pageable by username
     */
    public Page<ArticleLog> findAllByUsername(String username, Pageable pageable) {
        return articleLogRepository.findByUsername(username, pageable);
    }

    /**
     * find all article log by ip
     */
    public List<ArticleLog> findAllByIp(String ip) {
        return articleLogRepository.findByIp(ip);
    }

    /**
     * find all article log pageable by ip
     */
    public Page<ArticleLog> findAllByIp(String ip, Pageable pageable) {
        return articleLogRepository.findByIp(ip, pageable);
    }

    /**
     * save article log
     */
    public void save(ArticleLog articleLog) {
        articleLogRepository.save(articleLog);
    }

    /**
     * delete article log
     */
    public void delete(long id) {
        articleLogRepository.deleteById(id);
    }

    /**
     * delete article logs by username
     */
    public void delete(String username) {
        articleLogRepository.deleteAllByUsername(username);
    }
}
