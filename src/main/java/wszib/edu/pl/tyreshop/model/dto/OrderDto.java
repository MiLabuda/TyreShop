package wszib.edu.pl.tyreshop.model.dto;

import lombok.Data;
import wszib.edu.pl.tyreshop.model.Tyre;
import wszib.edu.pl.tyreshop.model.User;

@Data
public class OrderDto {
    private Integer orderId;
    private User user;
    private Tyre tyre;
    private String username;
    private String email;

}
