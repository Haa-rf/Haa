package fun.haarf.blog.jpa;

import fun.haarf.blog.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Integer> {
    Tag findByValue(String value);
}
