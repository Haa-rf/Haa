package fun.haarf.blog.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "user")
public class User implements Serializable {

    private static final long serialVersionUID = 3596014562850327775L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String username;
    private String password;
    private String phone;
    private String email;
    private String gender;
    private String birthday;
    private String personalBriefIntro;
    private String avatarImgUrl;
    private long lastLoginDate;
    private int accountExpired;
    private int accountLocked;
}
