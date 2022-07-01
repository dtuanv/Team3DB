package manager.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


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
    @NotBlank(message = "Street must be not blank")
    @Size(min=3, message = "please write a correct Street")
    private String street;
    @NotBlank(message = "House must be not blank")
    private String houseNum;

    private int postcode;
    @NotBlank(message = "Postcode must be not blank")
    @Size(min=3, message = "please write a correct city")
    private String city;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "delivery" )
    private Customer customer;

}
