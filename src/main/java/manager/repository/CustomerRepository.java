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
    @Query(value="SELECT * FROM (SELECT * FROM customer c LEFT JOIN delivery " +
            "USING(delivery_id) ) Cu WHERE first_name LIKE %?1%",
                    nativeQuery = true)
    public List<Customer> findCustomerWithFilter(String search);

}
