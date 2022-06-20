package wszib.edu.pl.tyreshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import wszib.edu.pl.tyreshop.model.Tyre;
import wszib.edu.pl.tyreshop.model.User;
import wszib.edu.pl.tyreshop.services.ITyreService;
import wszib.edu.pl.tyreshop.services.IUserService;

import java.math.BigDecimal;

@Component
public class StartupData implements CommandLineRunner {
    private IUserService userService;
    private ITyreService tyreService;

    @Autowired
    public StartupData(IUserService userService, ITyreService tyreService) {
        this.userService = userService;
        this.tyreService = tyreService;
    }


    @Override
    public void run(String... args) throws Exception {
        userAccounts();
        exampleTyres();
    }

    private void userAccounts(){
        User user1 = new User();
        User user2 = new User();

        user1.setFirstName("Frodo");
        user1.setLastName("Baggins");
        user1.setPassword("zlotypierscionek");
        user1.setPasswordConfirm("zlotypierscionek");
        user1.setEmail("ringeberear@shyre.me");
        user1.setUsername("FRODO");
        user1.setRole(User.Role.USER);

        user2.setFirstName("Samwise");
        user2.setLastName("Gamgee");
        user2.setPassword("potatoes");
        user2.setPasswordConfirm("potatoes");
        user2.setEmail("sam@shyre.me");
        user2.setUsername("SAM");
        user2.setRole(User.Role.ADMIN);

        userService.save(user1);
        userService.save(user2);
    }


    private void exampleTyres(){
        Tyre tyre1 = new Tyre();
        Tyre tyre2 = new Tyre();
        Tyre tyre3 = new Tyre();
        Tyre tyre4 = new Tyre();
        Tyre tyre5 = new Tyre();


        tyre1.setTyreManufacturer("Nokian");
        tyre1.setTyreModel("Seasonproof");
        tyre1.setTyreWidth(205);
        tyre1.setTyreProfile(55);
        tyre1.setTyreRim(16);
        tyre1.setEan(494949090L);
        tyre1.setQuantity(500);
        tyre1.setPrice(BigDecimal.valueOf(250));

        tyre2.setTyreManufacturer("Michelin");
        tyre2.setTyreModel("Primacy");
        tyre2.setTyreWidth(215);
        tyre2.setTyreProfile(65);
        tyre2.setTyreRim(117);
        tyre2.setEan(989898989L);
        tyre2.setQuantity(100);
        tyre2.setPrice(BigDecimal.valueOf(550));

        tyre3.setTyreManufacturer("Dunlop");
        tyre3.setTyreModel("Blue Response");
        tyre3.setTyreWidth(185);
        tyre3.setTyreProfile(65);
        tyre3.setTyreRim(15);
        tyre3.setEan(567567567L);
        tyre3.setQuantity(200);
        tyre3.setPrice(BigDecimal.valueOf(319));

        tyre4.setTyreManufacturer("Nexen");
        tyre4.setTyreModel("Nblue HD");
        tyre4.setTyreWidth(225);
        tyre4.setTyreProfile(45);
        tyre4.setTyreRim(18);
        tyre4.setEan(24664226L);
        tyre4.setQuantity(900);
        tyre4.setPrice(BigDecimal.valueOf(190));

        tyre5.setTyreManufacturer("Goodride");
        tyre5.setTyreModel("ZuperEco");
        tyre5.setTyreWidth(195);
        tyre5.setTyreProfile(65);
        tyre5.setTyreRim(15);
        tyre5.setEan(98754123L);
        tyre5.setQuantity(10);
        tyre5.setPrice(BigDecimal.valueOf(750));

        tyreService.save(tyre1);
        tyreService.save(tyre2);
        tyreService.save(tyre3);
        tyreService.save(tyre4);
        tyreService.save(tyre5);

    }


}
