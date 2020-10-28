package incubator.controller;

import incubator.service.user.GrantedAuthorityImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import sun.plugin.liveconnect.SecurityContextHelper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MainController {
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

}
