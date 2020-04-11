package fun.haarf.blog.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "tb_article_log")
public class ArticleLog implements Serializable {
    private static final long serialVersionUID = 7949000407665620648L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String username;
    private String operation;
    private long time;
    private String method;
    private String params;
    private String ip;
    private long createTime;
    private String location;

}
