package incubator.controller.user;



import incubator.service.interfaces.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class ChooseTest {
    private TestService testService;

    @Autowired
    public ChooseTest(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/chooseTest")
    @ResponseBody
    public List<String> chooseTest(@RequestParam(value = "topic", required = false) String topic) {
        return testService.getNamesTestsByTopic(topic);
    }

}
