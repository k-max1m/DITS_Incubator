package incubator.controller.user;

import incubator.service.user.TopicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserHome {
    @Autowired
    private TopicServiceImpl topicService;

    @GetMapping("/chooseTopic")
    public String chooseTest(ModelMap map) {
        map.put("topics", topicService.getAllTopic());
        return "user/chooseTest";
    }

    @GetMapping
    public String personalStatistic() {
        return "user/personalStatistic";
    }
}
