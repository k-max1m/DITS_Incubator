package incubator.controller.admin;

import incubator.entity.Topic;
import incubator.service.interfaces.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        model.addAttribute("result", "topic was added successfully");
        return "admin/addTopic";
    }
}
