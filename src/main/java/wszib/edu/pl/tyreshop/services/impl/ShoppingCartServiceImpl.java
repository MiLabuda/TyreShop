package wszib.edu.pl.tyreshop.services.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import wszib.edu.pl.tyreshop.model.Tyre;
import wszib.edu.pl.tyreshop.services.IShoppingCartService;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;


@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class ShoppingCartServiceImpl implements IShoppingCartService {

    private final Map<Tyre, Integer> cart = new LinkedHashMap<>();

    @Override
    public void addTyre(Tyre tyre) {
        if(cart.containsKey(tyre)) {
            cart.replace(tyre, cart.get(tyre) + 1);
        }else{
            cart.put(tyre, 1);
        }
    }

    @Override
    public void removeTyre(Tyre tyre) {
        if (cart.containsKey(tyre)) {
            if (cart.get(tyre) > 1) cart.replace(tyre, cart.get(tyre) - 1);
            else if (cart.get(tyre) == 1) cart.remove(tyre);
        }
    }

    @Override
    public void clearTyres() {
        cart.clear();
    }

    @Override
    public Map<Tyre, Integer> tyresInCart() {
        return Collections.unmodifiableMap(cart);
    }

    @Override
    public BigDecimal totalPrice() {
        return cart.entrySet().stream()
                .map(k -> k.getKey().getPrice().multiply(BigDecimal.valueOf(k.getValue()))).sorted()
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    @Override
    public void cartCheckout() {
        cart.clear();
        //TODO finalizing the order
    }
}
