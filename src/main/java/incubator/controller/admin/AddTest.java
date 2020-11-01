package incubator.controller.admin;

import incubator.service.interfaces.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/addTest")
public class AddTest {
    @Autowired
    TestService testService;

    @GetMapping("/")
    public String addTest(){
        return "admin/addTest";
    }
}
