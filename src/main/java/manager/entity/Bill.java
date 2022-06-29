package manager.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bill {
    @Id
    @SequenceGenerator(
            name= " bill_sequence",
            sequenceName = "bill_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "bill_sequence"
    )
    private Long billId;
    @ManyToOne(
           cascade = CascadeType.ALL
    )
    @JoinColumn(
            name="customer_id",
            referencedColumnName = "customerID"
    )
    private Customer customer;

}
