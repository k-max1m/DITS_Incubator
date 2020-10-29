package incubator.controller;

import incubator.entity.User;
import incubator.repository.UserRepos;
import incubator.service.user.GrantedAuthorityImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
//import sun.plugin.liveconnect.SecurityContextHelper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MainController {
    @Autowired
    UserRepos userRepos;

    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
    @GetMapping("/main")
    public String main(){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        List<? extends GrantedAuthority> collect = authorities.stream()
                .peek(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        if(collect.size() > 1){
            return "chooseRole";
        }
        if (collect.contains(new GrantedAuthorityImpl("USER"))) {
            return "user/user_home";
        } else if (collect.contains(new GrantedAuthorityImpl("ADMIN"))) {
            return "admin/admin_home";
        } else if (collect.contains(new GrantedAuthorityImpl("TUTOR"))) {
            return "tutor/tutor_home";
        } else return "main";
    }

    @GetMapping("/")
    public String mainPage() {
        return "main";
    }
    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }
    @PostMapping("/registration")
    public String getRegistration(@ModelAttribute User user){
        userRepos.save(user);
        return this.main();
    }

}
