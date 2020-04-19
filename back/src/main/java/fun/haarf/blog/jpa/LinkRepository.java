package fun.haarf.blog.jpa;

import fun.haarf.blog.entity.Link;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkRepository extends JpaRepository<Link, Integer> {

    Link findByName(String name);
}
