package cv.pn.equipament.services.implementation;


import cv.pn.equipament.dtos.*;
import cv.pn.equipament.models.Employee;
import cv.pn.equipament.models.Equipment;
import cv.pn.equipament.models.EquipmentType;
import cv.pn.equipament.models.LivingRoom;
import cv.pn.equipament.repositories.EmployeeRepository;
import cv.pn.equipament.repositories.EquipmentRepository;
import cv.pn.equipament.repositories.EquipmentTypeRepository;
import cv.pn.equipament.repositories.LivingRoomRepository;
import cv.pn.equipament.services.EquipmentService;
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
public class EquipmentServiceImpl implements EquipmentService {

    private final EquipmentRepository equipmentRepository;
    private  final EquipmentTypeRepository equipmentTypeRepository;
    private  final LivingRoomRepository livingRoomRepository;
    private  final EmployeeRepository employeeRepository;


    @Override
    public APIResponse insertEquipment(EquipmentDTO equipmentDTO) {
        Optional<EquipmentType> optionalEquipmentType = equipmentTypeRepository.findById(equipmentDTO.getIdEquipmentType());
        if (!optionalEquipmentType.isPresent()) {
            return APIResponse.builder().status(false).statusText(MessageState.ERRO_DE_INSERCAO).details(Arrays.asList("Tipo Equipamento " +MessageState.ID_NAO_EXISTE)).build();
        }
        Optional<LivingRoom> optionalLivingRoom = livingRoomRepository.findById(equipmentDTO.getIdLivingRoom());
        if (!optionalLivingRoom.isPresent()) {
            return APIResponse.builder().status(false).statusText(MessageState.ERRO_DE_INSERCAO).details(Arrays.asList("Sala/Departamento " +MessageState.ID_NAO_EXISTE)).build();
        }
        Optional<Employee> optionalEmployee = employeeRepository.findById(equipmentDTO.getIdEmployee());
        if (!optionalEmployee.isPresent()) {
            return APIResponse.builder().status(false).statusText(MessageState.ERRO_DE_INSERCAO).details(Arrays.asList("Utilizador " +MessageState.ID_NAO_EXISTE)).build();
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
            equipment.setObs(equipmentDTO.getObs());
            equipment.setEquipmentType(optionalEquipmentType.get());
            equipment.setLivingRoom(optionalLivingRoom.get());
            equipment.setEmployee(optionalEmployee.get());

            equipmentRepository.save(equipment);

            return APIResponse.builder().status(true).statusText(MessageState.INSERIDO_COM_SUCESSO).build();
        } catch (Exception e) {
            return APIResponse.builder().status(false).statusText(MessageState.ERRO_DE_INSERCAO).details(Arrays.asList(e.getMessage())).build();

        }

    }

    @Override
    public APIResponse updateEquipment(EquipmentDTO equipmentDTO) {

        Optional<Equipment> optionalEquipment = equipmentRepository.findById(equipmentDTO.getId());
        if(!optionalEquipment.isPresent()) {
            return APIResponse.builder().status(false).statusText(MessageState.ERRO).details(Arrays.asList("Equipamento "+MessageState.ID_NAO_EXISTE)).build();

        }

        Optional<EquipmentType> optionalEquipmentType = equipmentTypeRepository.findById(equipmentDTO.getIdEquipmentType());
        if (!optionalEquipmentType.isPresent()) {
            return APIResponse.builder().status(false).statusText(MessageState.ERRO_DE_INSERCAO).details(Arrays.asList("Tipo Equipamento " +MessageState.ID_NAO_EXISTE)).build();
        }
        Optional<LivingRoom> optionalLivingRoom = livingRoomRepository.findById(equipmentDTO.getIdEquipmentType());
        if (!optionalLivingRoom.isPresent()) {
            return APIResponse.builder().status(false).statusText(MessageState.ERRO_DE_INSERCAO).details(Arrays.asList("Sala/Departamento " +MessageState.ID_NAO_EXISTE)).build();
        }
        Optional<Employee> optionalEmployee = employeeRepository.findById(equipmentDTO.getIdEquipmentType());
        if (!optionalEmployee.isPresent()) {
            return APIResponse.builder().status(false).statusText(MessageState.ERRO_DE_INSERCAO).details(Arrays.asList("Utilizador " +MessageState.ID_NAO_EXISTE)).build();
        }


        Equipment equipment = optionalEquipment.get();

        try{

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
        equipment.setObs(equipmentDTO.getObs());
        equipment.setEquipmentType(optionalEquipmentType.get());
        equipment.setLivingRoom(optionalLivingRoom.get());
        equipment.setEmployee(optionalEmployee.get());

        equipmentRepository.save(equipment);
        return APIResponse.builder().status(true).statusText(MessageState.ATUALIZADO_COM_SUCESSO).build();

    } catch (Exception e) {
        return APIResponse.builder().status(false).statusText(MessageState.ERRO_AO_ATUALIZAR).details(Arrays.asList(e.getMessage())).build();

    }

}

    @Override
    public APIResponse getEquipment(String id) {

        Optional<Equipment> optionalEquipment = equipmentRepository.findById(id);
        if(!optionalEquipment.isPresent()){
            return APIResponse.builder().status(false).statusText(MessageState.ERRO).details(Arrays.asList("Equipamento "+MessageState.ID_NAO_EXISTE)).build();

    }

        Equipment equipment = optionalEquipment.get();



        try{

            EquipmentDTO equipmentDTO = new EquipmentDTO();

            equipmentDTO.setName(equipment.getName());
            equipmentDTO.setModel(equipment.getModel());
            equipmentDTO.setSerialNumber(equipment.getSerialNumber());
            equipmentDTO.setProcessor(equipment.getProcessor());
            equipmentDTO.setRom(equipment.getRom());
            equipmentDTO.setRam(equipment.getRam());
            equipmentDTO.setGeneration(equipment.getGeneration());
            equipmentDTO.setVelocity(equipment.getVelocity());
            equipmentDTO.setSystemType(equipment.getSystemType());
            equipmentDTO.setDmStateEquip(equipment.getDmStateEquip());
            equipmentDTO.setScreen(equipment.getScreen());
            equipmentDTO.setObs(equipment.getObs());


            EquipmentTypeDTO equipmentTypeDTO = new EquipmentTypeDTO();

            equipmentTypeDTO.setName(equipment.getEquipmentType().getName());
            equipmentTypeDTO.setCode(equipment.getEquipmentType().getCode());
            equipmentTypeDTO.setSelfId(equipment.getEquipmentType().getSelfId());

            EmployeeDTO employeeDTO = new EmployeeDTO();

            employeeDTO.setName(equipment.getEmployee().getName());
            employeeDTO.setFunction(equipment.getEmployee().getFunction());
            employeeDTO.setPatent(equipment.getEmployee().getPatent());
            employeeDTO.setDmTypeUser(equipment.getEmployee().getDmTypeUser());


            LivingRoomDTO livingRoomDTO = new LivingRoomDTO();

            livingRoomDTO.setName(equipment.getLivingRoom().getName());
            livingRoomDTO.setNumber(equipment.getLivingRoom().getNumber());
            livingRoomDTO.setDmPiso(equipment.getLivingRoom().getDmPiso());
            livingRoomDTO.setDmDivision(equipment.getLivingRoom().getDmDivision());
            livingRoomDTO.setContactPhone(equipment.getLivingRoom().getContactPhone());


            DepartmentDTO departmentDTO = new DepartmentDTO();


            departmentDTO.setName(equipment.getLivingRoom().getDepartment().getName());
            departmentDTO.setCode(equipment.getLivingRoom().getDepartment().getCode());
            departmentDTO.setSelfId(equipment.getLivingRoom().getDepartment().getSelfId());
            departmentDTO.setUserCreated(equipment.getLivingRoom().getDepartment().getUserCreated());
            departmentDTO.setId(equipment.getLivingRoom().getDepartment().getId());


            DetailEquipmentDTO detailEquipmentDTO = new DetailEquipmentDTO();

            detailEquipmentDTO.setEquipment(equipmentDTO);
            detailEquipmentDTO.setEquipmentType(equipmentTypeDTO);
            detailEquipmentDTO.setDepartment(departmentDTO);
            detailEquipmentDTO.setEmployee(employeeDTO);
            detailEquipmentDTO.setLivingRoom(livingRoomDTO);


            return APIResponse.builder().status(true).statusText(MessageState.SUCESSO).details(Arrays.asList(detailEquipmentDTO)).build();


    }catch (Exception e){
        return APIResponse.builder().status(false).statusText(MessageState.ERRO).details(Arrays.asList(e.getMessage())).build();
    }
}

    @Override
    public APIResponse getALLEquipment() {
        List<Equipment> equipments = equipmentRepository.findAll();

        /*List<Object> equipmentDTOS = equipments.stream()
                .map(equipment -> new EquipmentDTO(equipment.getId(),equipment.getName(),equipment.getModel(),equipment.getSerialNumber(),equipment.getProcessor(),equipment.getRom(),equipment.getRam(),equipment.getGeneration(),equipment.getVelocity(),equipment.getSystemType(),equipment.getDmStateEquip(),equipment.getScreen(),equipment.getObs())
                ).collect(Collectors.toList());*/
        return APIResponse.builder().status(true).statusText(MessageState.SUCESSO).details(Arrays.asList(equipmentRepository.findAll())).build();



    }
}
