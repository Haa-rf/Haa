package fun.haarf.blog.service;

import fun.haarf.blog.entity.User;
import fun.haarf.blog.jpa.UserRepository;
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

    public boolean updateUser(User user) {
        User fundUser = userRepository.findByUsername(user.getUsername());
        if (fundUser == null) {
            return false;
        }
        user.setId(fundUser.getId());
        user.setUsername(fundUser.getUsername());
        user.setPassword(StringUtils.isBlank(user.getPassword()) ? fundUser.getPassword() :
                encoder.encode(user.getPassword()));
        user.setPhone(StringUtils.isBlank(user.getPhone()) ? fundUser.getPhone() : user.getPhone());
        user.setEmail(StringUtils.isBlank(user.getEmail()) ? fundUser.getEmail() : user.getEmail());
        user.setGender(StringUtils.isBlank(user.getGender()) ? fundUser.getGender() : user.getGender());
        user.setBirthday(StringUtils.isBlank(user.getBirthday()) ? fundUser.getBirthday() : user.getBirthday());
        user.setPersonalBriefIntro(StringUtils.isBlank(user.getPersonalBriefIntro()) ? fundUser.getPersonalBriefIntro()
                : user.getPersonalBriefIntro());
        user.setAvatarImgUrl(StringUtils.isBlank(user.getAvatarImgUrl()) ? fundUser.getAvatarImgUrl() : user.getAvatarImgUrl());
        user.setLastLoginDate(StringUtils.isBlank(user.getLastLoginDate()) ? fundUser.getLastLoginDate() : user.getLastLoginDate());
        user.setAccountExpired(fundUser.getAccountExpired());
        user.setAccountLocked(fundUser.getAccountLocked());
        userRepository.saveAndFlush(user);
        return true;
    }


}
