package cv.pn.equipament.services.implementation;

import cv.pn.equipament.dtos.EquipmentTypeDTO;
import cv.pn.equipament.models.EquipmentType;
import cv.pn.equipament.repositories.EquipmentTypeRepository;
import cv.pn.equipament.services.EquipmentTypeService;
import cv.pn.equipament.utilities.APIResponse;
import cv.pn.equipament.utilities.MessageState;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class EquipmentTypeServiceImpl implements EquipmentTypeService {

    private final EquipmentTypeRepository equipmentTypeRepository;

    @Override
    public APIResponse insertEquipmentType(EquipmentTypeDTO equipmentTypeDTO) {

        Optional<EquipmentType> optionalEquipmentType = equipmentTypeRepository.findByCode(equipmentTypeDTO.getCode());
        if(!optionalEquipmentType.isEmpty()){
            return APIResponse.builder().status(false).statusText(MessageState.ERRO_DE_INSERCAO).details(Arrays.asList("Tipo Equipamento")).build();

        }

        EquipmentType equipmentType = new EquipmentType();

        try {

         equipmentType.setName(equipmentTypeDTO.getName());
         equipmentType.setCode(equipmentTypeDTO.getCode());
         equipmentType.setSelfId(equipmentTypeDTO.getSelfId());

        equipmentTypeRepository.save(equipmentType);
        return APIResponse.builder().status(true).statusText(MessageState.INSERIDO_COM_SUCESSO).build();
    }
        catch (Exception e) {
        return APIResponse.builder().status(false).statusText(MessageState.ERRO_DE_INSERCAO).details(Arrays.asList(e.getMessage())).build();

    }

}

    @Override
    public APIResponse updateEquipmentType(String id, EquipmentTypeDTO equipmentTypeDTO) {
        Optional<EquipmentType> optionalEquipmentType = equipmentTypeRepository.findById(id);
        if(optionalEquipmentType.isEmpty()){
            return  APIResponse.builder().status(false).statusText(MessageState.ERRO_AO_ATUALIZAR).details(Arrays.asList("Tipo Equipamento" + MessageState.ID_NAO_EXISTE)).build();
        }

        EquipmentType equipmentType = optionalEquipmentType.get();

        try {
         equipmentType.setName(equipmentTypeDTO.getName());
         equipmentType.setCode(equipmentTypeDTO.getCode());
         equipmentType.setSelfId(equipmentTypeDTO.getSelfId());

        equipmentTypeRepository.save(equipmentType);
        return APIResponse.builder().status(true).statusText(MessageState.ATUALIZADO_COM_SUCESSO).build();

    } catch (Exception e) {
        return APIResponse.builder().status(false).statusText(MessageState.ERRO_AO_ATUALIZAR).details(Arrays.asList(e.getMessage())).build();

    }

}

    @Override
    public APIResponse getEquipmentType(String id) {
        Optional<EquipmentType> optionalEquipmentType = equipmentTypeRepository.findById(id);
        if(!optionalEquipmentType.isPresent()){
            return APIResponse.builder().status(false).statusText(MessageState.ERRO).details(Arrays.asList("Tipo Equipamento" + MessageState.ID_NAO_EXISTE)).build();
        }
        EquipmentType equipmentType = optionalEquipmentType.get();

        EquipmentTypeDTO equipmentTypeDTO = new EquipmentTypeDTO();

        try {
         equipmentTypeDTO.setName(equipmentType.getName());
         equipmentTypeDTO.setCode(equipmentType.getCode());
         equipmentTypeDTO.setSelfId(equipmentType.getSelfId());

        return APIResponse.builder().status(true).statusText(MessageState.SUCESSO).details(Arrays.asList(equipmentTypeDTO)).build();



    } catch (Exception e) {
        return APIResponse.builder().status(false).statusText(MessageState.ERRO).details(Arrays.asList(e.getMessage())).build();
    }

}



    @Override
    public APIResponse getAllEquipmentType(String selfId) {
        List<EquipmentType> equipmentTypes = equipmentTypeRepository.findBySelfId(selfId);

        List<Object> equipmentTypesDTOS = equipmentTypes.stream()
                .map(equipmentType -> new EquipmentTypeDTO(equipmentType.getId(),equipmentType.getName(),equipmentType.getCode(),equipmentType.getSelfId())
                ).collect(Collectors.toList());
        return APIResponse.builder().status(true).statusText(MessageState.SUCESSO).details(equipmentTypesDTOS).build();
    }
}
