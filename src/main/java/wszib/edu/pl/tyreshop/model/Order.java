package wszib.edu.pl.tyreshop.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity(name = "t_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "t_user")
    private User user;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "t_tyre")
    private List<Tyre> tyres = new ArrayList<>();

    private Date orderDate;
    double price;
    @Enumerated(EnumType.STRING)
    Status status;

    public enum Status {
       ORDERDED,
        ACCEPTED,
        SHIPPED
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Order order = (Order) o;
        return orderId != null && Objects.equals(orderId, order.orderId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
