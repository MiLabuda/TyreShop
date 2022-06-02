package wszib.edu.pl.tyreshop.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity(name = "Tyre")
public class Tyre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tyreId;
    private int ean;
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
