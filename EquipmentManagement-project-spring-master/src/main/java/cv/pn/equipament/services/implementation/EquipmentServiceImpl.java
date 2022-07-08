package cv.pn.equipament.services.implementation;


import cv.pn.equipament.dtos.EquipmentDTO;
import cv.pn.equipament.models.Equipment;
import cv.pn.equipament.repositories.EquipmentRepository;
import cv.pn.equipament.services.EquipmentService;
import cv.pn.equipament.utilities.APIResponse;
import cv.pn.equipament.utilities.MessageState;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EquipmentServiceImpl implements EquipmentService {

    private final EquipmentRepository equipmentRepository;



    @Override
    public APIResponse insertEquipment(EquipmentDTO equipmentDTO) {
        Optional<Equipment> optionalEquipment = equipmentRepository.findById(equipmentDTO.getId());
        if (optionalEquipment.isEmpty()) {
            return APIResponse.builder().status(false).statusText(MessageState.ERRO_DE_INSERCAO).details(Arrays.asList("codigo existente")).build();
        }


        Equipment equipment = new Equipment();


        try {
            equipment.setName(equipmentDTO.getName());
            equipment.setModel(equipmentDTO.getModel());
            equipment.setSerialNumber(equipmentDTO.getSerialNumber());
            equipment.setProcessor(equipmentDTO.getProcessor());
            equipment.setRom(equipmentDTO.getRom());
            equipment.setRam(equipmentDTO.getRam());
            equipment.setGeneration(equipmentDTO.getGeneration());
            equipment.setVelocity(equipmentDTO.getVelocity());
            equipment.setSystemType(equipmentDTO.getSystemType());
            equipment.setDmStateEquip(equipmentDTO.getDmStateEquip());
            equipment.setScreen(equipmentDTO.getScreen());

            equipmentRepository.save(equipment);

            return APIResponse.builder().status(true).statusText(MessageState.INSERIDO_COM_SUCESSO).build();
        } catch (Exception e) {
            return APIResponse.builder().status(false).statusText(MessageState.ERRO_DE_INSERCAO).details(Arrays.asList(e.getMessage())).build();

        }

    }

    @Override
    public APIResponse updateEquipment(String id, EquipmentDTO equipmentDTO) {
        return null;
    }

    @Override
    public APIResponse getEquipment(String id) {
        return null;
    }

    @Override
    public APIResponse getALLEquipment(String serialNumber) {
        return null;
    }
}
