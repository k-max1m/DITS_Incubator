package incubator.controller;


import incubator.entity.User;
import incubator.repository.UserRepos;
import incubator.service.interfaces.RoleService;
import incubator.service.serviceForSecurity.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class MainController {
    @Autowired
    UserRepos userRepos;
    @Autowired
    RoleService roleService;
    @Autowired
    UserDetailServiceImpl userDetailService;

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

    @GetMapping("/registration")
    public String registration(Model model){
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String getRegistration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model){
        userForm.setRole(roleService.getRoleById(3));
        if (bindingResult.hasErrors()) {
            model.addAttribute("usernameError", bindingResult.getAllErrors().toString());
            return "registration";
        }
        if (!userDetailService.save(userForm)){
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "registration";
        }
        model.addAttribute("usernameError", "all will be ok!");
        return "registration";

    }

}
