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
public class Food {

    @Id
    @SequenceGenerator(
            name= " food_sequence",
            sequenceName = "food_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "food_sequence"
    )
    private Long foodId;
    private String foodName;
    @ManyToMany(
            cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST}
    )
    @JoinTable(name="FoodIngredients",
    joinColumns = @JoinColumn(name= "food_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredients_id")
    )
    private Set<Ingredients> ingredients;
    private String calorie;

}
