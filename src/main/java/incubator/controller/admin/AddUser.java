package incubator.controller.admin;

import incubator.entity.User;
import incubator.service.interfaces.UserService;
import incubator.service.user.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        model.addAttribute("result", "user was added");
        return "admin/addUser";
    }
}