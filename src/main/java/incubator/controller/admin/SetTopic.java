package incubator.controller.admin;

import incubator.entity.Topic;
import incubator.service.interfaces.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/admin/setTopic")
public class SetTopic {
    @Autowired
    TopicService topicService;

    @GetMapping("/{tId}")
    public String addTopic(@PathVariable int tId, Model model){
        model.addAttribute("topic", topicService.getById(tId));
        return "admin/setTopic";
    }

    @PostMapping("/{tId}")
    public String addTopic(@RequestParam String name, @RequestParam String description,
                           Model model, @PathVariable int tId){
        topicService.getById(tId).setDescription(description);
        topicService.getById(tId).setName(name);
        model.addAttribute("result", "topic was set");
        return "admin/setTopic";
    }
}
