package manager.repository;

import manager.entity.intern.DietType;
import manager.entity.intern.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT * FROM product Inner JOin product_diet_type USING (product_id)" +
            " INNER JOIN diet_type USING(diet_type_id)" , nativeQuery = true)
    public List<Product> getAllProduct();
    @Query(value = "SELECT * FROM product Inner JOin product_diet_type USING (product_id)" +
            " INNER JOIN diet_type USING(diet_type_id) WHERE diet_type_name LIKE %?1% " , nativeQuery = true)
    public List<Product> getAllProductWithCal(String name);

    @Query(value = "SELECT Count(*) FROM product Inner JOin product_diet_type USING (product_id)" +
            " INNER JOIN diet_type USING(diet_type_id) WHERE diet_type_name LIKE %?1% " , nativeQuery = true)
    public int countProductWith(String name);
}
