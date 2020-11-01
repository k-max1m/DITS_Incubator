package incubator.controller.admin;

import incubator.entity.Topic;
import incubator.service.interfaces.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin/addTopic")
public class AddTopic {
    @Autowired
    TopicService topicService;

    @GetMapping
    public String addTopic(){
        return "admin/addTopic";
    }
    @PostMapping
    public String addTopic(@RequestParam String name, @RequestParam String description, Model model){
        topicService.save(new Topic(name,description));
        model.addAttribute("result", "topic was added");
        return "admin/addTopic";
    }
}
