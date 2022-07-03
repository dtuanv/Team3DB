package manager.entity.intern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DietType {
  /* @Id
    @SequenceGenerator(
            name= " groupFood_sequence",
            sequenceName = "groupFood_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "groupFood_sequence"
    )

   */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dietTypeId;
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="product_diet_type",
            joinColumns = @JoinColumn(name = "diet_type_id",
                                    referencedColumnName = "dietTypeId"),
                                    inverseJoinColumns = @JoinColumn(name="product_id",
                                    referencedColumnName = "productId")
            )
    private List<Product> productList;


}
