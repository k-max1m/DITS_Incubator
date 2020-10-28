package incubator.controller.user;

import incubator.service.user.TestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ChooseTest {
    @Autowired
    private TestServiceImpl testService;

    @GetMapping("/goToTest")
    public String goTest() {
        return "user/testPage";
    }

    @GetMapping("/chooseTest")
    @ResponseBody
    public List<String> chooseTest(@RequestParam(value = "topic", required = false) String topic) {
        return testService.getNamesTestsByTopic(topic);
    }

}
