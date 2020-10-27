package incubator.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserHome {

    @GetMapping("/chooseTest")
    public String chooseTest() {
        return "user/chooseTest";
    }

    @GetMapping
    public String personalStatistic() {
        return "user/personalStatistic";
    }
}
