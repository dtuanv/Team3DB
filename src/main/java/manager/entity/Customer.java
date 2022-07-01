package manager.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {
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
    private Long customerId;
    @NotBlank(message = "First name must be not blank")
    @Size(min=2, message = "please write a correct name")
    private String firstName;
   // @NotBlank(message = "Last name must be not blank")
    @Size(min=2, message = "please write a correct name")
    private String lastName;
    @Email(message = "please write a correct mail")
    private String email;

    private String gender;

    @OneToOne(
            cascade = CascadeType.ALL, fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "delivery_id",
            referencedColumnName = "deliveryId"
    )
    private Delivery delivery;



}
