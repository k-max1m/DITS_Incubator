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
public class SetAUser {
    @Autowired
    UserService userService;
    @Autowired
    UserDetailServiceImpl userDetailService;
    @GetMapping("/")
    public String chooseToSet(Model model){
        model.addAttribute(userService.getAll());
        return "admin/setUser";
    }
    @GetMapping("/{uId}")
    public String getUserToSet(@PathVariable int uId, Model model){
        User user = userService.getById(uId);
        model.addAttribute("user", user);
        return "admin/setUser";
    }
    @PostMapping("/{uId}")
    public String setAUser(@PathVariable int uId,
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
    @PostMapping("/delete/{uId}")
    public String deleteUser(@PathVariable int uId, Model model){
        userService.deleteUserById(uId);
        return "admin/setUser";
    }
}
