package incubator.controller.admin;

import incubator.entity.User;
import incubator.repository.RoleRepos;
import incubator.service.interfaces.UserService;
import incubator.service.serviceForSecurity.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin/setUser")
public class SetUser {
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    UserService userService;
    @Autowired
    UserDetailServiceImpl userDetailService;
    @Autowired
    RoleRepos roleRepos;


    @GetMapping("/")
    public String chooseToSet(Principal principal, Model model){
        List<User> users = new ArrayList<>();;
        String login = principal.getName();
        for(User user: userService.getAll()){
            if(!login.equals(user.getLogin())){
                users.add(user);
            }
        }
        model.addAttribute("users",users);
        return "admin/setUser";
    }
    @GetMapping("/{uId}/")
    public String getUserToSet(@PathVariable int uId, Model model){
        User user = userService.getById(uId);
        model.addAttribute("user", user);
        return "admin/setUser";
    }
    @PostMapping("/{uId}/SetFirstName/")
    public String setFirstName(@PathVariable int uId,
                          @RequestParam String firstName, Model model){
        User user = userService.getById(uId);
        user.setFirstName(firstName);
        userService.updateFirstName(user);
        model.addAttribute("result", "FirstName was set successfully");
        return "admin/setUser";
    }
    @PostMapping("/{uId}/setLastName/")
    public String setLastName(@PathVariable int uId,
                           @RequestParam String lastName, Model model){
        User user = userService.getById(uId);
        user.setLastName(lastName);
        userService.updateLastName(user);
        model.addAttribute("result", "LastName was set successfully");
        return "admin/setUser";
    }
    @PostMapping("/{uId}/setLogin/")
    public String setLogin(@PathVariable int uId,
                           @RequestParam String login, Model model){
        User user = userService.getById(uId);
        user.setLogin(login);
        userService.updateLogin(user);
        model.addAttribute("result", "Login was set successfully");
        return "admin/setUser";
    }
    @PostMapping("/{uId}/setRole/")
    public String setRole(@PathVariable int uId,
                           @RequestParam int roleId, Model model){
        User user = userService.getById(uId);
        user.setRole(roleRepos.getByRoleId(roleId));
        userService.updateRole(user);
        model.addAttribute("result", "Login was set successfully");
        return "admin/setUser";
    }

    @PostMapping("/{uId}/setPassword/")
    public String setPassword(@PathVariable int uId,
                           @RequestParam String password, Model model){
        User user = userService.getById(uId);

        user.setPassword(bCryptPasswordEncoder.encode(password));
        userService.updatePassword(user);
        model.addAttribute("result", "Password was set successfully");
        return "admin/setUser";
    }
    @PostMapping("/{uId}/deleteUser/")
    public String deleteUser(@PathVariable int uId, Model model){
        userService.deleteUserById(uId);
        return "redirect:/admin/home";
    }
}
