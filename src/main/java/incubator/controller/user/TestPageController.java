package incubator.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestPageController {
    private static int counter = 0;
    @GetMapping("/nextPage")
    public String getNextPage() {
        if (counter < 3) {
            counter++;
            return "user/testPage";
        } else {
            counter = 0;
            return "user/resultPage";
        }
    }
}
