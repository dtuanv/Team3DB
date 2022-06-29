package manager.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FoodMenu {
    @Id
    @SequenceGenerator(
            name= " foodMenu_sequence",
            sequenceName = "foodMenu_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "foodMenu_sequence"
    )
    private Long foodMenuId;
    private String name;


}
