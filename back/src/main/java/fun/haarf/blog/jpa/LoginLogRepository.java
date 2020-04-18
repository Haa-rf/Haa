package fun.haarf.blog.jpa;

import fun.haarf.blog.entity.LoginLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoginLogRepository extends JpaRepository<LoginLog, Long> {

    List<LoginLog> findAllByUsername(String username);

    Page<LoginLog> findAllByUsername(String username, Pageable pageable);

    List<LoginLog> findAllByIp(String ip);

    Page<LoginLog> findAllByIp(String ip,Pageable pageable);
}
