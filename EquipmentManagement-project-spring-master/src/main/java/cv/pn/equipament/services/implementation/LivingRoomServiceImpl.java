package cv.pn.equipament.services.implementation;

import cv.pn.equipament.dtos.LivingRoomDTO;
import cv.pn.equipament.models.Department;
import cv.pn.equipament.models.LivingRoom;
import cv.pn.equipament.repositories.DepartmentRepository;
import cv.pn.equipament.repositories.LivingRoomRepository;
import cv.pn.equipament.services.LivingRoomService;
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
public class LivingRoomServiceImpl implements LivingRoomService {

    private  final LivingRoomRepository livingRoomRepository;
    private  final DepartmentRepository departmentRepository;

    @Override
    public APIResponse insertLivingRoom(LivingRoomDTO livingRoomDTO) {


        Optional<Department> optionalDepartment = departmentRepository.findById(livingRoomDTO.getIdDepartment());
        if(!optionalDepartment.isPresent()){
            return APIResponse.builder().status(false).statusText(MessageState.ERRO_DE_INSERCAO).details(Arrays.asList("Sala ")).build();

        }

        LivingRoom livingRoom = new LivingRoom();

        try{
        livingRoom.setName(livingRoomDTO.getName());
        livingRoom.setNumber(livingRoomDTO.getNumber());
        livingRoom.setDmPiso(livingRoomDTO.getDmPiso());
        livingRoom.setDepartment(optionalDepartment.get());
        livingRoom.setContactPhone(livingRoomDTO.getContactPhone());

        livingRoomRepository.save(livingRoom);
        return APIResponse.builder().status(true).statusText(MessageState.INSERIDO_COM_SUCESSO).build();

    }
    	catch (Exception e) {
        return APIResponse.builder().status(false).statusText(MessageState.ERRO_DE_INSERCAO).details(Arrays.asList(e.getMessage())).build();

    }

}

    @Override
    public APIResponse updateLivingRoom(String id, LivingRoomDTO livingRoomDTO) {

        Optional<LivingRoom> optionalLivingRoom = livingRoomRepository.findById(id);
        if (optionalLivingRoom.isEmpty()){
            return APIResponse.builder().status(false).statusText(MessageState.ERRO_AO_ATUALIZAR).details(Arrays.asList("Sala "+MessageState.ID_NAO_EXISTE)).build();

        }
        LivingRoom livingRoom = optionalLivingRoom.get();
        try {
          livingRoom.setName(livingRoomDTO.getName());
          livingRoom.setNumber(livingRoomDTO.getNumber());
          livingRoom.setDmPiso(livingRoomDTO.getDmPiso());
          livingRoom.setDmDivision(livingRoomDTO.getDmDivision());
          livingRoom.setContactPhone(livingRoomDTO.getContactPhone());


        livingRoomRepository.save(livingRoom);
        return APIResponse.builder().status(true).statusText(MessageState.ATUALIZADO_COM_SUCESSO).build();


    } catch (Exception e) {
        return APIResponse.builder().status(false).statusText(MessageState.ERRO_AO_ATUALIZAR).details(Arrays.asList(e.getMessage())).build();

    }

}

    @Override
    public APIResponse getLivingRoom(String id) {

        Optional<LivingRoom> optionalLivingRoom = livingRoomRepository.findById(id);
        if(!optionalLivingRoom.isPresent()){
            return APIResponse.builder().status(false).statusText(MessageState.ERRO).details(Arrays.asList("Sala "+MessageState.ID_NAO_EXISTE)).build();

        }
        LivingRoom livingRoom = optionalLivingRoom.get();


    try{

        LivingRoomDTO livingRoomDTO = new LivingRoomDTO();

        livingRoomDTO.setName(livingRoom.getName());
        livingRoomDTO.setNumber(livingRoom.getNumber());
        livingRoomDTO.setDmPiso(livingRoom.getDmPiso());
        livingRoomDTO.setDmDivision(livingRoom.getDmDivision());
        livingRoomDTO.setContactPhone(livingRoom.getContactPhone());

        return APIResponse.builder().status(true).statusText(MessageState.SUCESSO).details(Arrays.asList(livingRoomDTO)).build();

    }catch (Exception e){
        return APIResponse.builder().status(false).statusText(MessageState.ERRO).details(Arrays.asList(e.getMessage())).build();
    }
}

    @Override
    public APIResponse getAllLivingRoom() {
        List<LivingRoom> livingRooms = livingRoomRepository.findAll();

        /*List<Object> livingRoomDTOS = livingRooms.stream()
                .map(livingRoom -> new LivingRoomDTO(livingRoom.getId(),livingRoom.getName(),livingRoom.getNumber(),livingRoom.getDmPiso(),livingRoom.getDmDivision(),livingRoom.getContactPhone())
                ).collect(Collectors.toList());*/
        return APIResponse.builder().status(true).statusText(MessageState.SUCESSO).details(Arrays.asList(livingRoomRepository.findAll())).build();

    }
}
