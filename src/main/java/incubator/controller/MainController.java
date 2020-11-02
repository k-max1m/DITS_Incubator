package incubator.controller;

import incubator.entity.User;
import incubator.repository.UserRepos;
import incubator.service.interfaces.RoleService;
import incubator.service.user.GrantedAuthorityImpl;
import incubator.service.user.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

//import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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
    public String login() {

        return "login";
    }
    
    @GetMapping("/main")
    public String main(Model model){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        List<? extends GrantedAuthority> collect = authorities.stream()
                .peek(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        if(collect.size() > 1){
            List<String> roles = new ArrayList<>();
            for(GrantedAuthority gA: authorities){
                roles.add("/" + gA.toString().toLowerCase() + "/home");
            }
            model.addAttribute("roles", roles);
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
    public String mainPage(Principal principal, Model model) {
        if(principal != null && principal.getName() != null){
            model.addAttribute("userName", principal.getName());
        }
        else{
            model.addAttribute("userName", "sameName");
        }
        model.addAttribute("users",userRepos.getUserByUserIdNotNull());
        return "main";
    }

    @GetMapping("/registration")
    public String registration(Model model){
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String getRegistration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model){
        userForm.setRole(roleService.getRoleById(3));
        userDetailService.save(userForm);
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
