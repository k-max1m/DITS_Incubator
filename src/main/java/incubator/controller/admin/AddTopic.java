package incubator.controller.admin;

import incubator.entity.Topic;
import incubator.service.interfaces.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin/addTopic")
public class AddTopic {
    @Autowired
    TopicService topicService;

    @GetMapping("/")
    public String addTopic(){
        return "admin/addTopic";
    }

    @PostMapping("/")
    public String addTopic(@ModelAttribute("topicForm") Topic topicForm, Model model){
        topicService.save(topicForm);
        List<Topic> topics = new ArrayList<>();
        topics.add(topicService.getByDescription(topicForm.getDescription()));
        model.addAttribute("topics", topics);
        model.addAttribute("result", "topic was added successfully");
        return "admin/addTest";
    }
}
