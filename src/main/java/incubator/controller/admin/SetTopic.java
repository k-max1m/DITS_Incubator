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

    @GetMapping("/")
    private String choose(Model model){
        model.addAttribute("topics",topicService.getAllTopic());
        return "admin/setTopic";
    }

    @GetMapping("/{tId}")
    public String setTopic(@PathVariable int tId, Model model){
        model.addAttribute("topic", topicService.getById(tId));
        return "admin/setTopic";
    }

    @PostMapping("/{tId}/setDescription")
    public String setDescription(@RequestParam String description,
                           Model model, @PathVariable int tId){
        Topic topic = topicService.getById(tId);
        topic.setDescription(description);
        topicService.updateDescription(topic);
        model.addAttribute("topic", topicService.getById(tId));
        model.addAttribute("result", "topic was set");
        return "admin/setTopic";
    }

    @PostMapping("/{tId}/setName")
    public String setName(@RequestParam String name,
                           Model model, @PathVariable int tId){
        Topic topic = topicService.getById(tId);
        topic.setName(name);
        topicService.updateName(topic);
        model.addAttribute("topic", topicService.getById(tId));
        model.addAttribute("result", "topic was set");
        return "admin/setTopic";
    }

    @PostMapping("/{tId}/deleteTopic")
    public String setName(Model model, @PathVariable int tId){
        Topic topic = topicService.getById(tId);
        topicService.deleteTopic(topic);
        model.addAttribute("result", "topic was set");
        return "redirect:/admin/home";
    }
}
