package incubator.controller.admin;

import incubator.entity.Question;
import incubator.entity.Test;
import incubator.service.interfaces.QuestionService;
import incubator.service.interfaces.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin/addQuestion")
public class AddQuestion {
    @Autowired
    TestService testService;
    @Autowired
    QuestionService questionService;

    @GetMapping("/")
    public String addQuestion(Model model){
        model.addAttribute("tests", testService.getAll());
        return("admin/addQuestion"); }

    @PostMapping("/")
    public String addQuestion(@ModelAttribute("questionForm") Question questionForm,
                             @RequestParam(value = "retry", defaultValue = "false") boolean retry, Model model){
        questionForm.setTest(testService.getById(questionForm.getTestId()));
        questionService.save(questionForm);
        model.addAttribute("result","question added successfully");
        if (retry){
            model.addAttribute("tests", testService.getAll());
            return("admin/addQuestion");
        }
        List<Question> questions = new ArrayList<>();
        questions.add(questionService.getByDescription(questionForm.getDescription()));
        model.addAttribute("questions",questions);
        return ("admin/addLiterature");
    }
}
