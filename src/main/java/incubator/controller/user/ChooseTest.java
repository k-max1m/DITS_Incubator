package incubator.controller.user;

import incubator.entity.Answer;
import incubator.service.interfaces.AnswerService;
import incubator.service.interfaces.QuestionService;
import incubator.service.interfaces.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ChooseTest {
    @Autowired
    TestService testService;
    @Autowired
    QuestionService questionService;
    @Autowired
    AnswerService answerService;
    @GetMapping("/goToTest")
    public String goTest(Model model) {
        model.addAttribute("tests", testService.getAll());
        return "user/testPage";
    }
    @GetMapping("/goToTest/{testId}")
    public String doTest(Model model, @PathVariable int testId) {
        model.addAttribute("test", testService.getById(testId));
        model.addAttribute("questions", questionService.getAllByTest(testService.getById(testId)));
        return "user/testPage";
    }
    @PostMapping("/goToTest/{testId}")
    public String getAnswer(Model model, @PathVariable int testId, @ModelAttribute Answer answer) {
        answerService.save(answer);
        return "user/testPage";
    }


}
