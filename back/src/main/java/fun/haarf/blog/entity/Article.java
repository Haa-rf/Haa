package fun.haarf.blog.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "tb_article")
public class Article implements Serializable {

    private static final long serialVersionUID = -8884877669739378084L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private String cover;
    private String author;
    private int type;
    private String origin;
    private String content;
    private String contentMd;
    private String status;
    private long createTime;
    private long publishTime;
    private long lastEditTime;

}
