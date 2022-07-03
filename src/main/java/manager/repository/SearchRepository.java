package manager.repository;

import manager.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchRepository extends JpaRepository<Customer,Long> {
    @Query(value="SELECT Count(first_name) FROM (SELECT * FROM customer c LEFT JOIN delivery " +
        "USING(delivery_id) ) Cu WHERE first_name LIKE %?1%"  ,
        nativeQuery = true)
    public int countCustomer(String search);
    @Query(value="SELECT Count(first_name) FROM (SELECT * FROM customer c LEFT JOIN delivery " +
            "USING(delivery_id) ) Cu WHERE last_name LIKE %?1%"  ,
            nativeQuery = true)
    public int countCustomerWithLastName(String search);

    @Query(value="SELECT Count(first_name) FROM (SELECT * FROM customer c LEFT JOIN delivery " +
            "USING(delivery_id) ) Cu WHERE email LIKE %?1%"  ,
            nativeQuery = true)
    public int countCustomerWithEmail(String search);
    @Query(value="SELECT Count(gender) FROM (SELECT * FROM customer c LEFT JOIN delivery " +
            "USING(delivery_id) ) Cu WHERE gender = :gender"  ,
            nativeQuery = true)
    public int countCustomerWithGender(String gender);
    @Query(value="SELECT Count(first_name) FROM (SELECT * FROM customer c LEFT JOIN delivery " +
            "USING(delivery_id) ) Cu WHERE city LIKE %?1%"  ,
            nativeQuery = true)
    public int countCustomerWithCity(String search);


}
