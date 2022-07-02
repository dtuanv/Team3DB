package manager.repository;

import manager.entity.intern.DietType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DietTypeRepository extends JpaRepository<DietType,Long> {
}
