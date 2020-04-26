package fun.haarf.blog.service;

import fun.haarf.blog.entity.LoginLog;
import fun.haarf.blog.jpa.LoginLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginLogService {

    @Autowired
    private LoginLogRepository loginLogRepository;

    /**
     * find all login logs
     */
    public List<LoginLog> findAll() {
        return loginLogRepository.findAll();
    }

    /**
     * find all login logs pageable
     */
    public Page<LoginLog> findAll(Pageable pageable) {
        return loginLogRepository.findAll(pageable);
    }

    /**
     * find one user's all login logs
     */
    public List<LoginLog> findAllByUsername(String username) {
        return loginLogRepository.findByUsername(username);
    }

    /**
     * find one user's all login logs pageable
     */
    public Page<LoginLog> findAllByUsername(String username, Pageable pageable) {
        return loginLogRepository.findByUsername(username, pageable);
    }

    /**
     * find one IP's all login logs
     */
    public List<LoginLog> findAllByIP(String ip) {
        return loginLogRepository.findByIp(ip);
    }

    /**
     * find one IP's all login logs pageable
     */
    public Page<LoginLog> findAllByIP(String ip, Pageable pageable) {
        return loginLogRepository.findByIp(ip, pageable);
    }

    /**
     * save login log
     */
    public void save(LoginLog loginLog){
        loginLogRepository.save(loginLog);
    }

    /**
     * delete login log
     */
    public void delete(long id) {
        loginLogRepository.deleteById(id);
    }

    /**
     * delete login logs by username
     */
    public void delete(String username) {
        loginLogRepository.deleteByUsername(username);
    }

}
