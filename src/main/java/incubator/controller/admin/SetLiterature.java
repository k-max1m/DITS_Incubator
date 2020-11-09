package incubator.controller.admin;

import incubator.entity.Link;
import incubator.entity.Literature;
import incubator.service.interfaces.LiteratureService;
import incubator.service.interfaces.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/setLiterature")
public class SetLiterature {
    @Autowired
    LiteratureService literatureService;
    @Autowired
    QuestionService questionService;

    @GetMapping("/")
    private String choose(Model model){
        model.addAttribute("literatures",literatureService.getAllLiterature());
        return "admin/setLiterature";
    }
    @GetMapping("/{lId}/")
    public String setLink(@PathVariable int lId, Model model){
        model.addAttribute("questions", questionService.getAllQuestion());
        model.addAttribute("literature", literatureService.getByLiteratureId(lId));
        return("admin/setLiterature");
    }
    @PostMapping("/{lId}/setDescription/")
    public String setLink(@PathVariable int lId, @RequestParam String description , Model model){
        Literature lit = literatureService.getByLiteratureId(lId);
        lit.setDescription(description);
        literatureService.updateDescription(lit);
        model.addAttribute("result","description set successfully");
        model.addAttribute("literatures", literatureService.getByLiteratureId(lId));
        model.addAttribute("questions", questionService.getAllQuestion());
        return("admin/setLiterature");
    }
    @PostMapping("/{lId}/setQuestion/")
    public String setLiterature(@PathVariable int lId, @RequestParam int qId ,Model model){
        Literature lit = literatureService.getByLiteratureId(lId);
        lit.setQuestion(questionService.getByQuestionId(qId));
        literatureService.updateQuestion(lit);
        model.addAttribute("result","question set successfully");
        model.addAttribute("link",  literatureService.getByLiteratureId(lId));
        model.addAttribute("questions", questionService.getAllQuestion());
        return("admin/setLiterature");
    }
    @PostMapping("/{lId}/deleteLiterature/")
    public String deleteTest(Model model, @PathVariable int lId) {
        literatureService.deleteLiterature(literatureService.getByLiteratureId(lId));
        model.addAttribute("result", "Literature deleted successfully");
        return "redirect:/admin/home";
    }
}
