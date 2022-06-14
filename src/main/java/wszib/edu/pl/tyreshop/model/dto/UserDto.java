package wszib.edu.pl.tyreshop.model.dto;


import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto{
    @NotEmpty
    private String username;

    @NotEmpty
    private String password;
    private String matchingPassword;

    @NotEmpty
    private String email;




}
