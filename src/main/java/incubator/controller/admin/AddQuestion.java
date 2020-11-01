package incubator.controller.admin;

import incubator.entity.Question;
import incubator.entity.Test;
import incubator.service.interfaces.QuestionService;
import incubator.service.interfaces.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/addQuestion")
public class AddQuestion {
    @Autowired
    TestService testService;
    @Autowired
    QuestionService questionService;

    @GetMapping("/")
    public String addQuestion(){

        return("admin/addQuestion");
    }
    @PostMapping("/")
    public String addQuestion(@RequestParam String description, @RequestParam int testId, Model model){
        Test test = testService.getById(testId);
        questionService.save(new Question(description,test));
        model.addAttribute("result","question added successfully");
        return("admin/addQuestion");
    }
}
