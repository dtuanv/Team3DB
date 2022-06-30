package manager.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.transaction.Transactional;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "customer")
public class Delivery {
/*
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

 */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deliveryId;
    private String street;
    private String city;
    private int index;
    private String houseNum;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "delivery" )
    private Customer customer;

}
