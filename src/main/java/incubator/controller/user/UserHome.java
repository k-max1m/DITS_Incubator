package incubator.controller.user;

import incubator.entity.Topic;
import incubator.service.TestServiceImpl;
import incubator.service.TopicServiceImpl;
import incubator.service.interfaces.TestService;
import incubator.service.interfaces.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserHome {
    private TopicService topicService;

    private TestService testService;

    @Autowired
    public UserHome(TopicService topicService, TestService testService) {
        this.topicService = topicService;
        this.testService = testService;
    }

    @GetMapping("/chooseTopic")
    public String chooseTest(ModelMap map) {
        List<Topic> topics = topicService.getAllTopic();
        map.put("topics", topics);
        map.put("tests", testService.getTestsByTopic(topics.get(0)));
        return "user/chooseTest";
    }

    @GetMapping("/personalStatistic")
    public String personalStatistic() {
        return "redirect:/userStatistic";
    }
}
