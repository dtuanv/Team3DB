package manager.entity;

import lombok.*;

import javax.persistence.*;
import javax.transaction.Transactional;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "customer")
public class Delivery {
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
    private Long deliveryId;
    private String street;
    private String houseNum;
    private int plz;
    private String city;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "delivery" )
    private Customer customer;

}
