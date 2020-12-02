package incubator.config;

import incubator.service.RoleServiceImpl;
import incubator.service.UserServiceImpl;
import incubator.service.interfaces.RoleService;
import incubator.service.interfaces.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.mockito.Mockito.mock;

@Configuration
public class TestConfig {

    @Bean
    public UserService userService(){
        return new UserServiceImpl();
    }
    @Bean
    public RoleService roleService(){
        return new RoleServiceImpl();
    }
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
