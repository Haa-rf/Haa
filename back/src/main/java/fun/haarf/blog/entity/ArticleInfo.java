package fun.haarf.blog.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "tb_article_info")
public class ArticleInfo implements Serializable {
    private static final long serialVersionUID = 7949000407665620648L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int articleId;
    private int readNumber;
    private int likeNumber;

}
