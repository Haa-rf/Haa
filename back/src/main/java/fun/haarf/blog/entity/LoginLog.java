package fun.haarf.blog.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "tb_login_log")
public class LoginLog implements Serializable {

    private static final long serialVersionUID = -5631443707052661881L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String username;
    private String ip;
    private String location;
    private long loginTime;
    private String device;
}
