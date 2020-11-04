package incubator.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/admin")
public class AdminHome {
    @GetMapping("/home")
    public String homePage(Model model, Principal principal) {
        model.addAttribute("name", principal.getName());
        return "admin/admin_home";
    }
}
