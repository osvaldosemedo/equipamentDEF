package cv.pn.equipament.services;

import cv.pn.equipament.dtos.EquipmentTypeDTO;
import cv.pn.equipament.utilities.APIResponse;

public interface EquipmentTypeService {
    APIResponse insertEquipmentType(EquipmentTypeDTO equipmentTypeDTO);
    APIResponse updateEquipmentType(String id, EquipmentTypeDTO equipmentTypeDTO);
    APIResponse getEquipmentType(String id);
    APIResponse getAllEquipmentType(String selfId);
}
