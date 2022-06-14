package wszib.edu.pl.tyreshop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
        private List<Tyre> tyres = new ArrayList<Tyre>();
        private Date orderDate;
        double price;
        @Enumerated(EnumType.STRING)
        Status status;



        public enum Status {
           ORDERDED,
            ACCEPTED,
            SHIPPED
        }


}
