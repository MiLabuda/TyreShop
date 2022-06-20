package wszib.edu.pl.tyreshop.services;

import org.springframework.stereotype.Service;
import wszib.edu.pl.tyreshop.model.Tyre;

import java.math.BigDecimal;
import java.util.Map;


public interface IShoppingCartService {
    void addTyre(Tyre tyre);
    void removeTyre(Tyre tyre);
    void clearTyres();
    Map<Tyre, Integer> tyresInCart();
    BigDecimal totalPrice();
    void cartCheckout();

}
