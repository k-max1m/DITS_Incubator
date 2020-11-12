package incubator.controller.user;

import incubator.entity.Question;
import incubator.service.interfaces.AnswerService;
import incubator.service.interfaces.QuestionService;
import incubator.service.interfaces.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TestPageController {
    private QuestionService questionService;
    private AnswerService answerService;
    private TestService testService;
    private List<Question> questionsList;
    private Map<Question, List<Boolean>> correctQuestion;

    @Autowired
    public TestPageController(QuestionService questionService, AnswerService answerService, TestService testService) {
        this.questionService = questionService;
        this.answerService = answerService;
        this.testService = testService;
    }

    @GetMapping("/goToTest")
    public String goTest(@RequestParam String test, ModelMap map) {
        correctQuestion = new HashMap<>();
        questionsList = questionService.getAllByTest(testService.getTestByName(test));
        map.put("question", questionsList.get(0));
        map.put("answers", answerService.getAllByQuestion(questionsList.get(0)));
        map.put("page", 1);

        return "user/testPage";
    }

    @GetMapping("/nextPage")
    public String getNextPage(@RequestParam Integer page, @RequestParam List<Boolean> correct,
                              ModelMap map, RedirectAttributes redirectAttributes) {
        System.out.println(correct);
        correctQuestion.put(questionsList.get(page - 1), correct);
        if (page >= questionsList.size()) {
            Map<String, Object> redirectMap = new HashMap<>();
            redirectMap.put("page", page);
            redirectMap.put("correctQuestion", correctQuestion);
            redirectAttributes.addFlashAttribute("redirectMap", redirectMap);
            return "redirect:/resultTest";
        } else {
            Question question = questionsList.get(page);
            map.put("question", question);
            map.put("answers", answerService.getAllByQuestion(question));
            map.put("page", ++page);
            return "user/testPage";
        }
    }
}
