package fun.haarf.blog.security;

import fun.haarf.blog.entity.User;
import fun.haarf.blog.jpa.UserRepository;
import fun.haarf.blog.utils.Global;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@Configuration
@Slf4j
public class UserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            log.info("can't find user: {}", username);
            throw new UsernameNotFoundException("user not exists.");
        }
        List<GrantedAuthority> authorityList = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                new BCryptPasswordEncoder().encode(user.getPassword()),
                true,
                user.getAccountExpired() == Global.INT_FALSE,
                true,
                user.getAccountLocked() == Global.INT_FALSE,
                authorityList);
    }
}
