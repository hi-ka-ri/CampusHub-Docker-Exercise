package ra.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.demo.model.entity.Department;

import java.util.Optional;

@Repository
public interface DepartmetRepository extends JpaRepository<Department, String> {
    Optional<Department> findByDepartId(String departId);
}
