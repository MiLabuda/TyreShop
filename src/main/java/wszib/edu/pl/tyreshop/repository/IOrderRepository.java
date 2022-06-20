package wszib.edu.pl.tyreshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wszib.edu.pl.tyreshop.model.Order;
import wszib.edu.pl.tyreshop.model.User;

import java.util.List;


@Repository
public interface IOrderRepository extends JpaRepository<Order, Long> {
    List<Order> findOrdersByUser(User user);

    void deleteOrderByOrderId(Long orderId);

    boolean existsOrdersByUser(User user);

}

