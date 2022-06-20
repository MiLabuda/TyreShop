package wszib.edu.pl.tyreshop.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import wszib.edu.pl.tyreshop.services.ITyreService;

@Controller
public class CommonController {

    private final ITyreService tyreService;

    @Autowired
    public CommonController(ITyreService tyreService) {
        this.tyreService = tyreService;
    }

    @GetMapping(value = {"/","/index","/main"})
    public String main(Model model){
        model.addAttribute("tyres", tyreService.findAll());
        model.addAttribute("tyresCount", tyreService.count());
        return "main";
    }

    @GetMapping(value = {"/about"})
    public String main(){
        return "about";
    }

}
