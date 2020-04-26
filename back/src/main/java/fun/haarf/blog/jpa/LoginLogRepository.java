package fun.haarf.blog.jpa;

import fun.haarf.blog.entity.LoginLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoginLogRepository extends JpaRepository<LoginLog, Long> {

    List<LoginLog> findByUsername(String username);

    Page<LoginLog> findByUsername(String username, Pageable pageable);

    List<LoginLog> findByIp(String ip);

    Page<LoginLog> findByIp(String ip, Pageable pageable);

    void deleteByUsername(String username);
}
