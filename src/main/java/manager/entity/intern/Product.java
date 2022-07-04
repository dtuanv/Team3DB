package manager.entity.intern;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "ingredients")
public class Product {
    /*
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

     */


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String productName;
    @ManyToMany(
            cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST}
    )
    @JoinTable(name="productIngredients",
    joinColumns = @JoinColumn(name= "product_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredients_id")
    )

    private Set<Ingredients> ingredients;
    private String calorie;
}
