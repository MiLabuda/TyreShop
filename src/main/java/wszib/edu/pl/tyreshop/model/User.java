package wszib.edu.pl.tyreshop.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseModel{
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
