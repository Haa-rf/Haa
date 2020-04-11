package fun.haarf.blog.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "tb_category")
public class Category implements Serializable {

    private static final long serialVersionUID = 3919156510315309767L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String value;
}
