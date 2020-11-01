package incubator.controller.admin;

import incubator.entity.Question;
import incubator.entity.Statistic;
import incubator.entity.Test;
import incubator.service.interfaces.QuestionService;
import incubator.service.interfaces.StatisticService;
import incubator.service.interfaces.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/admin/testStatistic")
public class TestStatistic {
    @Autowired
    StatisticService statisticService;
    @Autowired
    QuestionService questionService;
    @Autowired
    TestService testService;

    @GetMapping("/{tId}")
    public String getTestStatistic(@PathVariable int tId, Model model){
        HashMap<Question, List<Statistic>> statistic = new HashMap<>();
        Test test = testService.getById(tId);
        for(Question question: questionService.getAllByTest(test)){
            statistic.put(question, statisticService.getByQuestion(question));

        }
        model.addAttribute("statistic", statistic);
        return "admin/TestStatistic";
    }
}
