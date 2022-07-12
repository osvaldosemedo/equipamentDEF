package cv.pn.equipament.repositories;

import cv.pn.equipament.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
    List<Employee> findByDmTypeUser(String DmTypeUser);
}
