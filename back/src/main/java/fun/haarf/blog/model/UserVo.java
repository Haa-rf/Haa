package fun.haarf.blog.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserVo implements Serializable {

    private static final long serialVersionUID = 2991094282364075618L;

    private String username;
    private String password;
    private String phone;
    private String email;
    private String gender;
    private String birthday;
    private String introduce;
    private String avatar;
}
