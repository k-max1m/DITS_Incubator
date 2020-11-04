package incubator.controller.admin;

import incubator.entity.User;
import incubator.service.interfaces.UserService;
import incubator.service.serviceForSecurity.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/addUser")
public class AddUser {
    @Autowired
    UserService userService;
    @Autowired
    UserDetailServiceImpl userDetailService;

    @GetMapping("/")
    public String setUser() {
        return "admin/addUser";
    }

    @PostMapping("/")
    public String setUser(@ModelAttribute("userForm") User userForm, Model model) {
        userDetailService.save(userForm);
        model.addAttribute("result", "user was added successfully");
        return "admin/addUser";
    }
}