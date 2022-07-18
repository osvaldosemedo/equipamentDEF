package cv.pn.equipament.repositories;

import cv.pn.equipament.models.EquipmentType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EquipmentTypeRepository extends JpaRepository<EquipmentType, String> {
    Optional<EquipmentType> findByCode(String Code);
    List<EquipmentType> findBySelfId(String SelfId);
    //List<EquipmentType> findAll();


}
