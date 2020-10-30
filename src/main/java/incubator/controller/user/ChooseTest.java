package incubator.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChooseTest {
    @GetMapping("/goToTest")
    public String goTest() {
        return "user/testPage";
    }
}
