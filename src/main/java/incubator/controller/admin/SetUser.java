package incubator.controller.admin;

import incubator.entity.User;
import incubator.service.interfaces.UserService;
import incubator.service.user.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/setUser")
public class SetUser {
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
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
    public String setFirstName(@PathVariable int uId,
                          @RequestParam String firstName, Model model){
        User user = userService.getById(uId);
        user.setFirstName(firstName);
        model.addAttribute("result", "FirstName was set successfully");
        return "admin/setUser";
    }
    @PostMapping("/{uId}/setLastName")
    public String setLastName(@PathVariable int uId,
                           @RequestParam String lastName, Model model){
        User user = userService.getById(uId);
        user.setLastName(lastName);
        model.addAttribute("result", "LastName was set successfully");
        return "admin/setUser";
    }
    @PostMapping("/{uId}/setLogin")
    public String setLogin(@PathVariable int uId,
                           @RequestParam String login, Model model){
        User user = userService.getById(uId);
        user.setLogin(login);
        model.addAttribute("result", "Login was set successfully");
        return "admin/setUser";
    }
    @PostMapping("/{uId}/setPassword")
    public String setPassword(@PathVariable int uId,
                           @RequestParam String password, Model model){
        User user = userService.getById(uId);

        user.setPassword(bCryptPasswordEncoder.encode(password));

        model.addAttribute("result", "Password was set successfully");
        return "admin/setUser";
    }
    @PostMapping("/delete/{uId}")
    public String deleteUser(@PathVariable int uId, Model model){
        userService.deleteUserById(uId);
        return "admin/setUser";
    }
}
