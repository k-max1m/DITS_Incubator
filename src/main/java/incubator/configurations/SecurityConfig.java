package incubator.configurations;

import incubator.service.user.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private UserDetailServiceImpl userDetailService;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/resources/css/**");
    }

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
                .antMatchers("/tutor/**").hasAuthority("TUTOR")
                .antMatchers("/user/**").hasAuthority("USER")
                .antMatchers("/user/**").hasAnyAuthority("USER", "ADMIN")
                .antMatchers("/user/**", "/tutor/**").hasAnyAuthority("USER", "TUTOR")
                .antMatchers("/admin/**", "/tutor/**").hasAnyAuthority("TUTOR", "ADMIN")
                .antMatchers("/**").hasAnyAuthority("USER", "ADMIN", "TUTOR")
                .antMatchers("/").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login")
                .usernameParameter("userName")
                .passwordParameter("password")
                .defaultSuccessUrl("/main")
                .and()
                .logout().permitAll().logoutSuccessUrl("/").invalidateHttpSession(true);
    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailService).passwordEncoder(bCryptPasswordEncoder());
    }
}
