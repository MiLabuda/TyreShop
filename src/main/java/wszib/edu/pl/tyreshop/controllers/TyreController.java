package wszib.edu.pl.tyreshop.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import wszib.edu.pl.tyreshop.model.Tyre;
import wszib.edu.pl.tyreshop.services.ITyreService;
import wszib.edu.pl.tyreshop.validator.TyreValidator;

@Controller
public class TyreController {

    private static final Logger logger = LoggerFactory.getLogger(TyreController.class);
    private final ITyreService tyreService;
    private final TyreValidator tyreValidator;

    @Autowired
    public TyreController(ITyreService tyreService, TyreValidator tyreValidator) {
        this.tyreService = tyreService;
        this.tyreValidator = tyreValidator;
    }

    @GetMapping("/tyre/new")
    public String newTyre(Model model){
        model.addAttribute("tyreForm", new Tyre());
        model.addAttribute("method", "new");
    return "tyre";
    }

    @PostMapping("/tyre/new")
    public String newTyre(@ModelAttribute("tyreForm") Tyre tyreForm, BindingResult bindingResult, Model model) {
        tyreValidator.validate(tyreForm, bindingResult);

        if(bindingResult.hasErrors()) {
            logger.error(String.valueOf(bindingResult.getFieldError()));
            model.addAttribute("method", "new");
            return "tyre";
        }
        tyreService.save(tyreForm);
        logger.debug(String.format("Tyre with id: %s successfully created.", tyreForm.getTyreId()));

        return "redirect:/main";
    }

    @GetMapping("/tyre/edit{id}")
    public String editTyre(@PathVariable("id") long tyreId, Model model){
        Tyre tyre = tyreService.getTyreById(tyreId);
        if(tyre != null) {
            model.addAttribute("tyreForm", tyre);
            model.addAttribute("method", "edit");
            return "product";
        }else{
            return "error/404";
        }
    }


    @PostMapping("/tyre/edit{id}")
    public String editTyre(@PathVariable("id") long tyreId, @ModelAttribute("tyreForm") Tyre tyreForm, BindingResult bindingResult, Model model) {
        tyreValidator.validate(tyreForm, bindingResult);

        if(bindingResult.hasErrors()) {
            logger.error(String.valueOf(bindingResult.getFieldError()));
            model.addAttribute("method", "edit");
            return "tyre";
        }
        tyreService.edit(tyreId, tyreForm);
        logger.debug(String.format("Tyre with id: %s has been successfully edited.", tyreId));

        return "redirect:/main";
    }

    @PostMapping("/tyre/delete/{id}")
    public String deleteProduct(@PathVariable("id") long tyreId) {
        Tyre tyre = tyreService.getTyreById(tyreId);

        if(tyre !=null) {
            tyreService.delete(tyreId);
            logger.debug(String.format("Tyre with id: %s successfully deleted.", tyre.getTyreId()));
            return "redirect:/main";
        }else{
            return "error/404";
        }

    }
}
