package wszib.edu.pl.tyreshop.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import wszib.edu.pl.tyreshop.model.Tyre;
import wszib.edu.pl.tyreshop.services.IShoppingCartService;
import wszib.edu.pl.tyreshop.services.ITyreService;

@Controller
public class CartController {
    private static final Logger logger = LoggerFactory.getLogger(CartController.class);
    private final IShoppingCartService shoppingCartService;
    private final ITyreService tyreService;

    public CartController(IShoppingCartService shoppingCartService, ITyreService tyreService) {
        this.shoppingCartService = shoppingCartService;
        this.tyreService = tyreService;
    }

    @GetMapping("/cart")
    public String cart(Model model) {

        model.addAttribute("tyres", shoppingCartService.tyresInCart());
        model.addAttribute("totalPrice", shoppingCartService.totalPrice());

        return "cart";
    }

    @GetMapping("/cart/add/{id}")
    public String addProductToCart(@PathVariable("id") long id) {
        Tyre tyre = tyreService.getTyreById(id);
        if (tyre != null) {
            shoppingCartService.addTyre(tyre);
            logger.debug(String.format("Tyre with id: %s added to shopping cart.", id));
        }
        return "redirect:/main";
    }

    @GetMapping("/cart/remove/{id}")
    public String removeProductFromCart(@PathVariable("id") long id) {
        Tyre tyre = tyreService.getTyreById(id);
        if (tyre != null) {
            shoppingCartService.removeTyre(tyre);
            logger.debug(String.format("Tyre with id: %s removed from shopping cart.", id));

        }
        return "redirect:/cart";
    }

    @GetMapping("/cart/clear")
    public String clearProductsInCart() {

        shoppingCartService.clearTyres();
        logger.debug(String.format("The cart is cleared"));

        return "redirect:/cart";
    }

    @GetMapping("/cart/checkout")
    public String cartCheckout() {

        shoppingCartService.cartCheckout();

        return "order";
    }


}
