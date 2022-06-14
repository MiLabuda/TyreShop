package wszib.edu.pl.tyreshop.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "t_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private String street;
    private String city;
    private String postcode;
    private Role role;





    public enum Role {
        ADMIN,
        CONSULTANT,
        CUSTOMER
    }
}
