package incubator.controller.user;

import incubator.entity.Question;
import incubator.service.interfaces.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import java.util.Map;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ResultTest {
    private StatisticService statisticService;

    @Autowired
    public ResultTest(StatisticService statisticService) {
        this.statisticService = statisticService;
    }

    @GetMapping("/resultTest")
    public String resultPage(ModelMap map, @ModelAttribute("redirectMap") Map<String, Object> redirectMap) {
        Map<Question, List<Integer>> correctQuestion = (Map<Question, List<Integer>>) redirectMap.get("correctQuestion");
        List<List<Object>> resultList = statisticService.saveResultTest(correctQuestion);
        String correct = (String) resultList.get(resultList.size() - 1).get(0);
        resultList.remove(resultList.size() - 1);
        map.put("correct", correct);
        map.put("resultList", resultList);
        return "user/resultPage";
    }
}
