package incubator.controller.admin;

import incubator.entity.Test;
import incubator.service.interfaces.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping("/")
    public String addTest(@ModelAttribute("testForm")Test testForm, Model model){
        testService.save(testForm);
        model.addAttribute("result", "test was added successfully");
        return "admin/addTest";
    }
}
