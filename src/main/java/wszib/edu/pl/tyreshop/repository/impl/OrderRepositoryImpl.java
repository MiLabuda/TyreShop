package wszib.edu.pl.tyreshop.repository.impl;

import wszib.edu.pl.tyreshop.model.Order;
import wszib.edu.pl.tyreshop.model.User;
import wszib.edu.pl.tyreshop.repository.IOrderRepository;

import java.util.List;

public class OrderRepositoryImpl implements IOrderRepository {

    @Override
    public List<Order> findOrderByUser(User user) {
        return null;
    }

    @Override
    public void cancelOrderByOrderId(Long OrderId) {

    }

    @Override
    public boolean existsOrderByUser(User user) {
        return false;
    }
}
