package wszib.edu.pl.tyreshop.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "t_order")
public class Order {

    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
        private int orderId;
        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "t_user")
        private User user;
        @OneToMany(fetch = FetchType.EAGER)
        @JoinColumn(name = "t_tyre")
        private List<Tyre> tyres = new ArrayList<Tyre>();
        double price;
        Status status;



        public enum Status {
           ORDERDED,
                ACCEPTED,
                SHIPPED
        }


}
