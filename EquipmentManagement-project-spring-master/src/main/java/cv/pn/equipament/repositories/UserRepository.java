package cv.pn.equipament.repositories;

import cv.pn.equipament.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Employee,String> {
}
