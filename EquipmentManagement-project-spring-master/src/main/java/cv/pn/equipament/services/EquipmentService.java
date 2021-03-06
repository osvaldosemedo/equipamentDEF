package cv.pn.equipament.services;

import cv.pn.equipament.dtos.EquipmentDTO;
import cv.pn.equipament.utilities.APIResponse;

public interface EquipmentService {
    APIResponse insertEquipment(EquipmentDTO equipmentDTO);
    APIResponse updateEquipment(EquipmentDTO equipmentDTO );
    APIResponse getEquipment(String id);
    APIResponse getALLEquipment();

}
