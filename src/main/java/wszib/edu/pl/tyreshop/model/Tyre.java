package wszib.edu.pl.tyreshop.model;

import lombok.Data;

@Data
public class Tyre {
    private int id;
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
