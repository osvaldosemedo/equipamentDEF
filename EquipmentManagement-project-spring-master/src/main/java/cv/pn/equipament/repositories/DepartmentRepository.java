package cv.pn.equipament.repositories;

import cv.pn.equipament.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface DepartmentRepository extends JpaRepository <Department, String> {

   Optional<Department> findByCode(String Code);
   List<Department> findBySelfId(String s);




}
