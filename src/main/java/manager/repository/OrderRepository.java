/*package manager.repository;

import manager.entity.intern.DietType;
import manager.entity.intern.db.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<ProductType,Long> {
    @Query(value = "SELECT diet_type_id ,diet_type_name FROM product Inner JOin product_diet_type USING (product_id)" +
            " INNER JOIN diet_type USING(diet_type_id)" , nativeQuery = true)
    public List<DietType> getDietName();
}

 */
