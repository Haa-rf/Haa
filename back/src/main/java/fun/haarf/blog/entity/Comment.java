package fun.haarf.blog.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "tb_comment")
public class Comment implements Serializable {

    private static final long serialVersionUID = -8884877669739378084L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long pId;
    private long cId;
    private int articleId;
    private String articleTitle;
    private String name;
    private String replyName;
    private long createTime;
    private String content;
    private String email;
    private String url;
    private String ip;
    private String device;
    private String address;

}
