package cv.pn.equipament.repositories;

import cv.pn.equipament.models.Employee;
import cv.pn.equipament.models.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EquipmentRepository extends JpaRepository<Equipment, String> {
    List<Equipment> findAll();

}
