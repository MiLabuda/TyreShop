package wszib.edu.pl.tyreshop.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wszib.edu.pl.tyreshop.model.Order;
import wszib.edu.pl.tyreshop.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface IOrderRepository extends JpaRepository<Order, Long> {
    List<Order> findOrderByUser(User user);

    void cancelOrderByOrderId(Long OrderId);

    boolean existsOrderByUser(User user);

    @Override
    default List<Order> findAll(Sort sort) {
        return null;
    }

}
