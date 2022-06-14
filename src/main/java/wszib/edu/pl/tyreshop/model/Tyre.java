package wszib.edu.pl.tyreshop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "t_tyre")
public class Tyre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tyreId;
    private Long ean;
    @Enumerated(EnumType.STRING)
    private Season season;
    private String tyreManufacturer;
    private String tyreModel;
    private int tyreWidth;
    private int tyreProfile;
    private int tyreRim;
    private int loadIndex;
    private char speedIndex;
    private int dot;
    private int quantity;
    private double price;





    public enum Season {
        SUMMER,
        WINTER,
        ALLSEASON
    }
}
