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

@Controller
public class ResultTest {
    private StatisticService statisticService;

    @Autowired
    public ResultTest(StatisticService statisticService) {
        this.statisticService = statisticService;
    }

    @GetMapping("/resultTest")
    public String resultPage(ModelMap map, @ModelAttribute("redirectMap") Map<String, Object> redirectMap) {
        Map<Question, Boolean> correctQuestion = (Map<Question, Boolean>) redirectMap.get("correctQuestion");
        List<List<Object>> resultList = statisticService.saveResultTest(correctQuestion);
        map.put("resultList", resultList);
        return "user/resultPage";
    }
}
