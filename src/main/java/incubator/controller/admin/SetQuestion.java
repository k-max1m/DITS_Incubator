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
public class SetQuestion {
    @Autowired
    TestService testService;
    @Autowired
    QuestionService questionService;

    @GetMapping("/{qId}")
    public String setQuestion(@PathVariable int qId, Model model){
        model.addAttribute("question", questionService.getByQuestionId(qId));
        return("admin/setQuestion");
    }
    @PostMapping("/{qId}")
    public String addQuestion(@RequestParam String description, @RequestParam int testId, Model model,
                              @PathVariable String qId){
        Test test = testService.getById(testId);
        questionService.save(new Question(description,test));
        model.addAttribute("result","question added successfully");
        return("admin/setQuestion");
    }
}

