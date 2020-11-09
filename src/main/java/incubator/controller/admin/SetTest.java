package incubator.controller.admin;

import incubator.entity.Test;
import incubator.entity.Topic;
import incubator.service.interfaces.TestService;
import incubator.service.interfaces.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/setTest")
public class SetTest {
    @Autowired
    TestService testService;
    @Autowired
    TopicService topicService;
    @GetMapping("/")
    private String choose(Model model){
        model.addAttribute("tests",testService.getAll());
        return "admin/setTest";
    }
    @GetMapping("/{tId}")
    public String getTest(@PathVariable int tId, Model model){
        model.addAttribute("test",testService.getById(tId));
        model.addAttribute("topics",topicService.getAllTopic());
        return "admin/setTest";
    }

    @PostMapping("/{tId}/setName")
    public String getTest(@PathVariable int tId, String name, Model model){
        Test test = testService.getById(tId);
        test.setName(name);
        testService.updateName(test);
        model.addAttribute("test",testService.getById(tId));
        model.addAttribute("topics",topicService.getAllTopic());
        model.addAttribute("result","Name was set successfully");
        return "admin/setTest";
    }

    @PostMapping("/{tId}/setDescription")
    public String getDescription(@PathVariable int tId, String description, Model model){
        Test test = testService.getById(tId);
        test.setDescription(description);
        testService.updateDescription(test);
        model.addAttribute("test",testService.getById(tId));
        model.addAttribute("topics",topicService.getAllTopic());
        model.addAttribute("result","Description was set successfully");
        return "admin/setTest";
    }

    @PostMapping("/{tId}/setTopic")
    public String getTopic(@PathVariable int tId, int topicId, Model model){
        Topic topic = topicService.getById(topicId);
        Test test = testService.getById(tId);
        test.setTopic(topic);
        testService.updateTopic(test);
        model.addAttribute("test",testService.getById(tId));
        model.addAttribute("topics",topicService.getAllTopic());
        model.addAttribute("result","Topic was set successfully");
        return "admin/setTest";
    }

    @PostMapping("/{tId}/deleteTest")
    public String deleteTest(@PathVariable int tId, Model model){
        Test test = testService.getById(tId);
        testService.deleteTest(test);
        model.addAttribute("result","Topic was set successfully");
        return "redirect:/admin/home";
    }
}
