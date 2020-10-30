package incubator.controller.user;

import incubator.service.interfaces.UserStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PersonalStatistic {
    @Autowired
    private UserStatisticService statisticService;
    @GetMapping("/homeUser")
    public String homePage() {
        return "user/user_home";
    }

    @GetMapping("/userStatistic")
    public String statistic(ModelMap model) {
        model.put("statistic", statisticService.getUserStatistic());
        return "user/personalStatistic";
    }
}
