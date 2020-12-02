package incubator.controller.admin;

import incubator.entity.Link;
import incubator.service.interfaces.LinkService;
import incubator.service.interfaces.LiteratureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/addLink")
public class AddLink {
    @Autowired
    LinkService linkService;
    @Autowired
    LiteratureService literatureService;

    @GetMapping("/")
    public String addLink(Model model){
        model.addAttribute("literatures",literatureService.getAllLiterature());
        return("admin/addLink"); }

    @PostMapping("/")
    public String addLink(@ModelAttribute("linkForm") Link linkForm,
                              Model model){
        linkForm.setLiterature(literatureService.getByLiteratureId(linkForm.getLiteratureId()));
        linkService.save(linkForm);
        model.addAttribute("literatures",literatureService.getAllLiterature());
        model.addAttribute("result","link added successfully");
        return("admin/addLink");
    }
}
