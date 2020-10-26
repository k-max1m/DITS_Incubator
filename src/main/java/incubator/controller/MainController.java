package incubator.controller;

import incubator.repository.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    @Autowired
    private UserRepos userRepos;

    @GetMapping("/")
    public String mainPage(){
        return "main";
    }
    
    @PostMapping("/")
    public String login(){
        return "user";
    }
    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }
}
