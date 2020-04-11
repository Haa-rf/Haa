package fun.haarf.blog.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "tb_tag")
public class Tag implements Serializable {

    private static final long serialVersionUID = 5783735456057498902L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String value;

}
