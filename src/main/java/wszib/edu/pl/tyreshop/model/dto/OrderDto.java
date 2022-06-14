package wszib.edu.pl.tyreshop.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import wszib.edu.pl.tyreshop.model.Tyre;
import wszib.edu.pl.tyreshop.model.User;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Long orderId;
    private User user;
    private Tyre tyre;
    private String username;
    private String email;
    private Date orderDate;

}
