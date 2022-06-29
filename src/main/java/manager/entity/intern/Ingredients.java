package manager.entity.intern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ingredients {
    @Id
    @SequenceGenerator(
            name= " ingredients_sequence",
            sequenceName = "ingredients_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ingredients_sequence"
    )
    private Long ingredientsId;
    private String ingredientsName;
    @ManyToMany(
            mappedBy = "ingredients"
    )
     private Set<Food> food;
    private String amount;

}
