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

    @GetMapping("/")
    private String choose(Model model){
        model.addAttribute("questions",questionService.getAllQuestion());
        return "admin/setQuestion";
    }
    @GetMapping("/{qId}")
    public String setQuestion(@PathVariable int qId, Model model){
        model.addAttribute("question", questionService.getByQuestionId(qId));
        model.addAttribute("tests",testService.getAll());
        return("admin/setQuestion");
    }
    @PostMapping("/{qId}/setDescription/")
    public String setDescription(@ModelAttribute String description,  Model model,
                              @PathVariable int qId){
        Question question = questionService.getByQuestionId(qId);
        question.setDescription(description);
        questionService.updateDescription(question);
        model.addAttribute("question", questionService.getByQuestionId(qId));
        model.addAttribute("tests", testService.getAll());
        model.addAttribute("result","question set successfully");
        return("admin/setQuestion");
    }
   @PostMapping("/{qId}/setTest/")
    public String SetTest(@RequestParam int testId, Model model,
                              @PathVariable int qId){
        Question question = questionService.getByQuestionId(qId);
        question.setTest(testService.getById(testId));
        questionService.updateTest(question);
        model.addAttribute("question", questionService.getByQuestionId(qId));
        model.addAttribute("tests",testService.getAll());
        model.addAttribute("result","question set successfully");
        return("admin/setQuestion");
    }
    @PostMapping("/{qId}/deleteQuestion/")
    public String deleteTest(Model model, @PathVariable int qId){
        questionService.deleteQuestion(questionService.getByQuestionId(qId));
        model.addAttribute("result","question deleted successfully");
        return "redirect:/admin/home";
    }
}

