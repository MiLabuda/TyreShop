package wszib.edu.pl.tyreshop.model;

public class User {
    private int id;
    private String login;
    private String pass;
    private Role role;





    public enum Role {
        ADMIN,
        CONSULTANT,
        CUSTOMER
    }
}
