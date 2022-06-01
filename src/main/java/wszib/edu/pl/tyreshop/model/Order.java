package wszib.edu.pl.tyreshop.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity(name = "t_order")
public class Order {

    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private User user;
        private Tyre tyre;
        double price;
        Status status;



        public enum Status {
           ORDERDED,
                ACCEPTED,
                SHIPPED
        }


}
