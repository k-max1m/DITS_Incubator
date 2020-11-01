package incubator.controller.user;

import incubator.entity.Answer;
import incubator.entity.Question;
import incubator.entity.Statistic;
import incubator.entity.User;
import incubator.service.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class ResultTest {
    @Autowired
    UserService userService;
    @Autowired
    QuestionService questionService;
    @Autowired
    TestService testService;
    @Autowired
    StatisticService statisticService;
    @GetMapping("/result/{testId}")
    public String getResult(Principal principal, @PathVariable int testId){
        User user = userService.findByLogin(principal.getName());
        List<Question> questions = questionService.getAllByTest(testService.getById(testId));
        Map<Question, List<Statistic>> statisticMap = new HashMap<>();
        for(Question question: questions){
            statisticMap.put(question, statisticService.getByQuestinAndUser(question,user));
        }
        return "user/resultPage";
    }
}
