package manager.repository;

import manager.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    @Query(value = "select * from customer c inner join delivery  d " +
            "ON c.delivery_id = d.delivery_id", nativeQuery = true)
    public List<Customer> findCustomerWithAddress();
 /*   @Query(value="SELECT * FROM (SELECT * FROM customer c LEFT JOIN delivery " +
            "USING(delivery_id) ) Cu WHERE first_name LIKE %?1%" +
            " OR last_name LIKE %?2% OR email LIKE %?3% OR gender LIKE %?4% OR city LIKE %?5%"
            ,
                    nativeQuery = true)

  */
    @Query(value="SELECT * FROM (SELECT * FROM customer c LEFT JOIN delivery " +
            "USING(delivery_id) ) Cu WHERE first_name LIKE %?1%"
     //     +  " OR last_name LIKE %?2% "
            ,
            nativeQuery = true)
    public List<Customer> findCustomerWithFilter(String firstName);
    @Query(value="SELECT * FROM (SELECT * FROM customer c LEFT JOIN delivery " +
            "USING(delivery_id) ) Cu WHERE last_name LIKE %?1%"  ,
            nativeQuery = true)
    public List<Customer> findCustomerWithLastName(String lastName);
    @Query(value="SELECT * FROM (SELECT * FROM customer c LEFT JOIN delivery " +
            "USING(delivery_id) ) Cu WHERE email LIKE %?1%"  ,
            nativeQuery = true)
    public List<Customer> findCustomerWithEmail(String email);

    @Query(value="SELECT * FROM (SELECT * FROM customer c LEFT JOIN delivery " +
            "USING(delivery_id) ) Cu WHERE gender LIKE %?1%"  ,
            nativeQuery = true)
    public List<Customer> findCustomerWithGender(String gender);
    @Query(value="SELECT * FROM (SELECT * FROM customer c LEFT JOIN delivery " +
            "USING(delivery_id) ) Cu WHERE city LIKE %?1%"  ,
            nativeQuery = true)
    public List<Customer> findCustomerWithCity(String city);

}
