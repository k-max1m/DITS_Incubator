package incubator.controller.tutor;

import incubator.entity.User;
import incubator.service.interfaces.StatisticService;
import incubator.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("tutor/statistic")
public class UserStatistic {
    @Autowired
    UserService userService;
    @Autowired
    StatisticService statisticService;

    @GetMapping("{userId}")
    public String getUserStatistic(@PathVariable int userId, Model model){
        User user = userService.getById(userId);
        model.addAttribute("statistic",statisticService.getByUser(user));
        return "user/personalStatistic";
    }
}
