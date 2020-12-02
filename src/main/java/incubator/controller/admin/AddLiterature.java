package incubator.controller.admin;

import incubator.entity.Link;
import incubator.entity.Literature;
import incubator.service.interfaces.LiteratureService;
import incubator.service.interfaces.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/addLiterature")
public class AddLiterature {
    @Autowired
    LiteratureService literatureService;
    @Autowired
    QuestionService questionService;

    @GetMapping("/")
    public String addLink(Model model){
        model.addAttribute("questions",questionService.getAllQuestion());
        return("admin/addLiterature"); }

    @PostMapping("/")
    public String addLink(@ModelAttribute("litForm") Literature litForm,
                          Model model){
        litForm.setQuestion(questionService.getByQuestionId(litForm.getLiteratureId()));
        literatureService.save(litForm);
        model.addAttribute("questions",questionService.getAllQuestion());
        model.addAttribute("result","question added successfully");
        return("admin/addLiterature");
    }
}
