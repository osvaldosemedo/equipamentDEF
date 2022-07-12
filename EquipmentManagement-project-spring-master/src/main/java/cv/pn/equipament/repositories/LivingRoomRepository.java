package cv.pn.equipament.repositories;

import cv.pn.equipament.models.LivingRoom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivingRoomRepository extends JpaRepository<LivingRoom, String> {
    List<LivingRoom> findByDmDivision(String DmDivision);
}
