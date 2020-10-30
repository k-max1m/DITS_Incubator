package incubator.configurations;

import incubator.service.user.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailServiceImpl userDetailService;

    @Autowired
    private CustomSuccessHandler customSuccessHandler;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.csrf().disable().authorizeRequests()
                .antMatchers("/","/registration", "/login")
                .not().fullyAuthenticated()
                .antMatchers("/admin/**").hasAuthority("ADMIN")
                .antMatchers("/tutor/**").hasAnyAuthority("TUTOR","ADMIN")
                .antMatchers("/user/**").hasAnyAuthority("USER","TUTOR","ADMIN")
                .antMatchers("/").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginProcessingUrl("/login")
                .usernameParameter("login")
                .passwordParameter("password")
                .defaultSuccessUrl("/main")
                .and()
                .logout().permitAll().logoutSuccessUrl("/").invalidateHttpSession(true);
    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication().passwordEncoder(bCryptPasswordEncoder())
                .withUser("user").password(bCryptPasswordEncoder().encode("user")).roles("USER").and()
                .withUser("admin").password(bCryptPasswordEncoder().encode("admin")).roles("ADMIN");
    }
}
