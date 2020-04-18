package fun.haarf.blog.service;

import fun.haarf.blog.entity.User;
import fun.haarf.blog.jpa.UserRepository;
import fun.haarf.blog.model.UserVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder encoder;

    /**
     * register a user
     */
    public boolean registerUser(User user) {
        User fundUser = userRepository.findByUsername(user.getUsername());
        if (fundUser != null) {
            return false;
        }
        user.setPassword(encoder.encode(user.getPassword()));
        user.setLastLoginDate(System.currentTimeMillis());
        userRepository.saveAndFlush(user);
        return true;
    }

    /**
     * get a user by username
     */
    public User getUser(String username) {
        User fundUser = userRepository.findByUsername(username);
        if (fundUser == null) {
            return new User();
        }

        return fundUser;
    }

    /**
     * update user info
     */
    public boolean updateUser(UserVo userVo) {
        User fundUser = userRepository.findByUsername(userVo.getUsername());
        if (fundUser == null) {
            return false;
        }
        fundUser.setPassword(StringUtils.isBlank(userVo.getPassword()) ? fundUser.getPassword() :
                encoder.encode(userVo.getPassword()));
        fundUser.setPhone(StringUtils.isBlank(userVo.getPhone()) ? fundUser.getPhone() : userVo.getPhone());
        fundUser.setEmail(StringUtils.isBlank(userVo.getEmail()) ? fundUser.getEmail() : userVo.getEmail());
        fundUser.setGender(StringUtils.isBlank(userVo.getGender()) ? fundUser.getGender() : userVo.getGender());
        fundUser.setBirthday(StringUtils.isBlank(userVo.getBirthday()) ? fundUser.getBirthday() : userVo.getBirthday());
        fundUser.setIntroduce(StringUtils.isBlank(userVo.getIntroduce()) ? fundUser.getIntroduce()
                : userVo.getIntroduce());
        fundUser.setAvatar(StringUtils.isBlank(userVo.getAvatar()) ? fundUser.getAvatar() :
                userVo.getAvatar());
        userRepository.saveAndFlush(fundUser);
        return true;
    }

    /**
     * update user last login time when successful
     */
    public boolean updateLastLoginDate(String username, long date) {
        User fundUser = userRepository.findByUsername(username);
        if (fundUser == null) {
            return false;
        }
        fundUser.setLastLoginDate(date);
        userRepository.saveAndFlush(fundUser);
        return true;
    }



}
