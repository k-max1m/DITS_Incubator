package incubator.controller.admin;

import incubator.entity.Link;
import incubator.service.interfaces.LinkService;
import incubator.service.interfaces.LiteratureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/setLink")
public class SetLink {
    @Autowired
    LinkService linkService;
    @Autowired
    LiteratureService literatureService;


    @GetMapping("/")
    private String choose(Model model){
        model.addAttribute("links",linkService.getAll());
        return "admin/setLink";
    }
    @GetMapping("/{lId}/")
    public String setLink(@PathVariable int lId, Model model){
        model.addAttribute("link", linkService.getById(lId));
        model.addAttribute("literatures", literatureService.getAllLiterature());
        return("admin/setLink");
    }
    @PostMapping("/{lId}/setLink/")
    public String setLink(@PathVariable int lId, @RequestParam String link ,Model model){
        Link aLink = linkService.getById(lId);
        aLink.setLink(link);
        linkService.updateLink(aLink);
        model.addAttribute("result","link set successfully");
        model.addAttribute("link", linkService.getById(lId));
        model.addAttribute("literatures", literatureService.getAllLiterature());
        return("admin/setLink");
    }
    @PostMapping("/{lId}/setLiterature/")
    public String setLiterature(@PathVariable int lId, @RequestParam int literatureId ,Model model){
        Link aLink = linkService.getById(lId);
        aLink.setLiterature(literatureService.getByLiteratureId(literatureId));
        linkService.updateLiterature(aLink);
        model.addAttribute("result","literature set successfully");
        model.addAttribute("link", linkService.getById(lId));
        model.addAttribute("literatures", literatureService.getAllLiterature());
        return("admin/setLink");
    }
    @PostMapping("/{lId}/deleteLink/")
    public String deleteTest(Model model, @PathVariable int lId) {
        linkService.deleteLink(linkService.getById(lId));
        model.addAttribute("result", "Link deleted successfully");
        return "redirect:/admin/home";
    }
}
