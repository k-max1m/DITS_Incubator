package incubator.controller.user;

import incubator.entity.Question;
import incubator.entity.Statistic;
import incubator.entity.Test;
import incubator.entity.User;
import incubator.service.interfaces.QuestionService;
import incubator.service.interfaces.StatisticService;
import incubator.service.interfaces.TestService;
import incubator.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.*;

@Controller
@RequestMapping("/user")
public class PersonalStatistic {
    @Autowired
    UserService userService;
    @Autowired
    StatisticService statisticService;
    @Autowired
    QuestionService questionService;
    @Autowired
    TestService testService;
    @GetMapping("/home")
    public String homePage(Principal principal, Model model) {
        String login = principal.getName();
        User user = userService.findByLogin(login);
        HashMap<Test,HashMap<Question,List<Statistic>>> statistics = new HashMap<>();
        List<Test> tests = testService.getAll();
        for(Test test: tests){
            HashMap<Question,List<Statistic>> qStat = new HashMap<>();
            for(Question question: questionService.getAllByTest(test)){
                qStat.put(question,statisticService.getByQuestinAndUser(question,user));
            }
            statistics.put(test,qStat);
        }
        model.addAttribute("statistics", statistics);
        return "user/personalStatistic";
    }
}
