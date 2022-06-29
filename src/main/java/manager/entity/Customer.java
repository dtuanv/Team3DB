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
public class Customer {

    @Id
    @SequenceGenerator(
            name= " customer_sequence",
            sequenceName = "customer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_sequence"
    )
    private Long customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String gender;

    @OneToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "delivery_id",
            referencedColumnName = "deliveryId"
    )
    private Delivery delivery;



}
