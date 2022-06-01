package wszib.edu.pl.tyreshop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {


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
