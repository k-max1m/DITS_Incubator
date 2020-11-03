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
@RequestMapping("/admin/setQuestion")
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
    @PostMapping("/{qId}/setDescription")
    public String setDescription(@RequestParam String description,  Model model,
                              @PathVariable int qId){
        Question question = questionService.getByQuestionId(qId);
        question.setDescription(description);
        model.addAttribute("result","question added successfully");
        return("admin/setQuestion");
    }
    @PostMapping("/{qId}/setDescription")
    public String addQuestion(@RequestParam int testId, Model model,
                              @PathVariable int qId){
        Question question = questionService.getByQuestionId(qId);
        question.setTest(testService.getById(testId));
        model.addAttribute("result","question added successfully");
        return("admin/setQuestion");
    }
}

