package manager.repository;

import manager.entity.intern.DietType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DietTypeRepository extends JpaRepository<DietType,Long> {
    @Query(value = "SELECT diet_type_id ,diet_type_name FROM product Inner JOin product_diet_type USING (product_id)" +
            " INNER JOIN diet_type USING(diet_type_id)" , nativeQuery = true)
    public List<DietType> getDietName();

    @Query(value = "SELECT * FROM product Inner JOin product_diet_type USING (product_id)" +
            " INNER JOIN diet_type USING(diet_type_id)" , nativeQuery = true)
    public List<DietType> getAllDietName();
}
