package incubator.controller.user;

import incubator.entity.Answer;
import incubator.entity.Question;
import incubator.entity.Test;
import incubator.service.TestServiceImpl;
import incubator.service.interfaces.AnswerService;
import incubator.service.interfaces.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TestPageController {
    private QuestionService questionService;
    private AnswerService answerService;
    private TestServiceImpl testService;
    private List<Question> questionsList;

    @Autowired
    public TestPageController(QuestionService questionService, AnswerService answerService, TestServiceImpl testService) {
        this.questionService = questionService;
        this.answerService = answerService;
        this.testService = testService;
    }

    @GetMapping("/goToTest")
    public String goTest(@RequestParam String test, ModelMap map) {
        questionsList = questionService.getAllByTest(testService.getTestByName(test));
        System.out.println(questionsList);
        map.put("question", questionsList.get(0));
        map.put("answers", answerService.getAllByQuestion(questionsList.get(0)));
        map.put("page", 1);

        return "user/testPage";
    }

    @GetMapping("/nextPage")
    public String getNextPage(@RequestParam Integer page, ModelMap map) {
        if (page >= questionsList.size()) {
            return "user/resultPage";
        } else {
            Question question = questionsList.get(page);
            map.put("question", question);
            map.put("answers", answerService.getAllByQuestion(question));
            map.put("page", ++page);
            return "user/testPage";
        }
    }
}
