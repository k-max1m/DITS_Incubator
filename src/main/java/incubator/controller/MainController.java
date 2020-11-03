package incubator.controller;

import incubator.service.user.GrantedAuthorityImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class MainController {
    @GetMapping("/login")
    public String login(ModelMap model) {
        return "login";
    }
    
    @GetMapping("/main")
    public String main(ModelMap model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        List<String> collect = authorities.stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        if (collect.size() > 1) {
            Map<String, String> roles = collect.stream().collect(Collectors.toMap(o -> o, o -> "/" +  o.toLowerCase() + "/home"));
            model.put("roles", roles);
            return "chooseRole";
        }
        if (collect.contains("USER")) {
            return "user/user_home";
        } else if (collect.contains("ADMIN")) {
            return "admin/admin_home";
        } else if (collect.contains("TUTOR")) {
            return "tutor/tutor_home";
        } else {
            return "login";
        }
    }

    @GetMapping("/")
    public String mainPage() {
        return "login";
    }

}
