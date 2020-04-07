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

    public User getUser(User user) {
        User fundUser = userRepository.findByUsername(user.getUsername());
        if (fundUser == null) {
            return new User();
        }

        return fundUser;
    }

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
        fundUser.setPersonalBriefIntro(StringUtils.isBlank(userVo.getPersonalBriefIntro()) ? fundUser.getPersonalBriefIntro()
                : userVo.getPersonalBriefIntro());
        fundUser.setAvatarImgUrl(StringUtils.isBlank(userVo.getAvatarImgUrl()) ? fundUser.getAvatarImgUrl() : userVo.getAvatarImgUrl());
        userRepository.saveAndFlush(fundUser);
        return true;
    }

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
