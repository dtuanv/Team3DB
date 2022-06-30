package manager.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FoodGroup {
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
    private Long groupFoodId;
    private String name;
}
