package incubator.controller.admin;

import incubator.entity.Test;
import incubator.service.interfaces.TestService;
import incubator.service.interfaces.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/addTest")
public class AddTest {
    @Autowired
    TestService testService;
    @Autowired
    TopicService topicService;

    @GetMapping("/")
    public String addTest(Model model){
        model.addAttribute("topics", topicService.getAllTopic());
        return "admin/addTest";
    }

    @PostMapping("/")
    public String addTest(@ModelAttribute("testForm")Test testForm, Model model){
        testForm.setTopic(topicService.getById(testForm.getTopicId()));
        testService.save(testForm);
        model.addAttribute("result", "test was added successfully");
        return "admin/addTest";
    }
}
