package incubator.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserHome {

    @GetMapping("/chooseTest")
    public String chooseTest(Principal principal, Model model) {
        model.addAttribute("userName",principal.getName());
        return "user/chooseTest";
    }

    @GetMapping("/statistic")
    public String personalStatistic() {
        return "user/personalStatistic";
    }
}
