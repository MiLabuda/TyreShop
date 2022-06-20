package wszib.edu.pl.tyreshop.model;


import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity(name = "t_tyre")
public class Tyre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tyreId;

    @NotNull
    private Long ean;

//    @NotNull
//    @NotEmpty
//    @Enumerated(EnumType.STRING)
//    private Season season;

    @NotNull
    @NotEmpty
    private String tyreManufacturer;

    @NotNull
    @NotEmpty
    private String tyreModel;

    @NotNull
    private int tyreWidth;

    @NotNull
    private int tyreProfile;

    @NotNull
    private int tyreRim;

//    @NotNull
//    @NotEmpty
//    private int loadIndex;
//
//    @NotNull
//    @NotEmpty
//    private char speedIndex;
//
//    @NotNull
//    @NotEmpty
//    private int dot;

    @NotNull
    private int quantity;

    @NotNull
    private BigDecimal price;

//    public enum Season {
//        SUMMER,
//        WINTER,
//        ALLSEASON
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Tyre tyre = (Tyre) o;
        return tyreId != null && Objects.equals(tyreId, tyre.tyreId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
