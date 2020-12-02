package incubator.controller.admin;

import incubator.entity.Role;
import incubator.entity.User;
import incubator.repository.RoleRepos;
import incubator.service.interfaces.RoleService;
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
    UserDetailServiceImpl userDetailService;
    @Autowired
    RoleService roleService;

    @GetMapping("/")
    public String addUser() {
        return "admin/addUser";
    }

    @PostMapping("/")
    public String addUser(@ModelAttribute("userForm") User userForm, Model model) {
        userForm.setRole(roleService.getRoleById(userForm.getRoleId()));
        userDetailService.save(userForm);
        model.addAttribute("result", "user was added successfully");
        return "admin/addUser";
    }
}