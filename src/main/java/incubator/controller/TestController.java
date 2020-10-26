package incubator.controller;

import incubator.entity.Answer;
import incubator.entity.Test;
import incubator.repository.TestRepos;
import incubator.repository.TopicRepos;
import incubator.service.AnswerServiceImpl;
import incubator.service.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TestController {
    private AnswerServiceImpl answerService;

    @Autowired
    public void setAnswerService(AnswerServiceImpl answerService) {
        this.answerService = answerService;
    }

    @Autowired
    QuestionServiceImpl questionService;

    @GetMapping("/")
    public String testController(ModelMap map) {

        List<Answer> list = answerService.getAllByQuestion(questionService.getByQuestionId(1));

        map.put("answer", list);
        return "test";
    }
}
