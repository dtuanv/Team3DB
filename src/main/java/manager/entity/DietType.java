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
}