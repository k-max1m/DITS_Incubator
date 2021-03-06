package incubator.controller.admin;

import incubator.entity.User;
import incubator.service.interfaces.StatisticService;
import incubator.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin/userStatistic")
public class GetUserStatistic {
    @Autowired
    UserService userService;
    @Autowired
    StatisticService statisticService;

    @GetMapping("/")
    public String userList(Model model){
        List<User> users = new ArrayList<>();
        for(User user: userService.getAll()){
            if(user.getRole().getRoleId() != 2){
                users.add(user);
            }
        }
        model.addAttribute("users", users);
        return "admin/userStatistic";
    }
    @GetMapping("/{uId}")
    public String getUserStatistic(@PathVariable int uId, Model model){
        User user = userService.getById(uId);
        model.addAttribute("statistic", statisticService.getByUser(user));
        return "admin/userStatistic";
    }
}
