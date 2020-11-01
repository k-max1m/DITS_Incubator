package incubator.controller.admin;

import incubator.entity.User;
import incubator.service.interfaces.UserService;
import incubator.service.user.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/setUser")
public class SetUser {
    @Autowired
    UserService userService;
    @Autowired
    UserDetailServiceImpl userDetailService;

    @GetMapping("/{uId}")
    public String setUser(@PathVariable int uId, Model model){
        User user = userService.getById(uId);
        model.addAttribute("user", user);
        return "admin/setUser";
    }
    @PostMapping("/{uId}")
    public String setUser(@PathVariable int uId,
                          @ModelAttribute("userForm") User userForm, Model model){
        User user = userService.getById(uId);
        user.setRole(userForm.getRole());
        user.setPassword(userForm.getPassword());
        user.setFirstName(userForm.getFirstName());
        user.setLastName(userForm.getLastName());
        user.setLogin(userForm.getLogin());
        model.addAttribute("result", "user was set");
        return "admin/setUser";
    }
}
