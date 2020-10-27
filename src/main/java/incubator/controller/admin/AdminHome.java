package incubator.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminHome {
    @GetMapping("/home")
    public String homePage() {
        return "admin/admin_home";
    }
}
