package cv.pn.equipament.services.implementation;

import cv.pn.equipament.dtos.DepartmentDTO;
import cv.pn.equipament.models.Department;
import cv.pn.equipament.repositories.DepartmentRepository;
import cv.pn.equipament.services.DepartmentService;
import cv.pn.equipament.utilities.APIResponse;

import cv.pn.equipament.utilities.MessageState;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static cv.pn.equipament.utilities.ApiUtilities.getRandomAlphabetic;
import static cv.pn.equipament.utilities.ApiUtilities.getRandomNumber;


@RequiredArgsConstructor
@Service

public class DepartmentServiceImpl implements DepartmentService {


    private final DepartmentRepository departmentRepository;


    @Override
    public APIResponse insertDepartment(DepartmentDTO departmentDTO) {

        Department department = new Department();

        try {
            int i = getRandomNumber(000,999);
            String s = getRandomAlphabetic(2);
            department.setName(departmentDTO.getName());
            department.setCode(s.concat(String.valueOf(i)));
            department.setSelfId(departmentDTO.getSelfId());
            department.setUserCreated(departmentDTO.getUserCreated());

            departmentRepository.save(department);

            return APIResponse.builder().status(true).statusText(MessageState.INSERIDO_COM_SUCESSO).build();


        } catch (Exception e) {
            return APIResponse.builder().status(false).statusText(MessageState.ERRO_DE_INSERCAO).details(Arrays.asList(e.getMessage())).build();

        }

    }


    public APIResponse updateDepartment(String id, DepartmentDTO departmentDTO) {

        Optional<Department> optionalDepartment = departmentRepository.findById(id);
        if (optionalDepartment.isEmpty()) {
            return APIResponse.builder().status(false).statusText(MessageState.ERRO_AO_ATUALIZAR).details(Arrays.asList("Departamento " + MessageState.ID_NAO_EXISTE)).build();
        }
        Department department = optionalDepartment.get();


        try {
            department.setName(departmentDTO.getName());
            department.setUserCreated(departmentDTO.getUserCreated());

            departmentRepository.save(department);
            return APIResponse.builder().status(true).statusText(MessageState.ATUALIZADO_COM_SUCESSO).build();


        } catch (Exception e) {
            return APIResponse.builder().status(false).statusText(MessageState.ERRO_AO_ATUALIZAR).details(Arrays.asList(e.getMessage())).build();

        }

    }

    @Override
    public APIResponse getDepartment(String id) {


        Optional<Department> optionalDepartment = departmentRepository.findById(id);
        if (!optionalDepartment.isPresent()) {
            return APIResponse.builder().status(false).statusText(MessageState.ERRO).details(Arrays.asList("Departamento " + MessageState.ID_NAO_EXISTE)).build();

        }
        Department department = optionalDepartment.get();


        try {

            DepartmentDTO departmentDTO = new DepartmentDTO();


            departmentDTO.setName(department.getName());
            departmentDTO.setCode(department.getCode());
            departmentDTO.setSelfId(department.getSelfId());
            departmentDTO.setUserCreated(department.getUserCreated());
            departmentDTO.setId(department.getId());


            return APIResponse.builder().status(true).statusText(MessageState.SUCESSO).details(Arrays.asList(departmentDTO)).build();


        } catch (Exception e) {
            return APIResponse.builder().status(false).statusText(MessageState.ERRO).details(Arrays.asList(e.getMessage())).build();
        }
    }

    @Override
    public APIResponse getAllDepartment(String selfId) {
        List<Department> departments = departmentRepository.findBySelfId(selfId);

        List<Object> departmentDTOS = departments.stream()
                .map(department -> new DepartmentDTO(department.getId(), department.getName(), department.getCode(), department.getSelfId(), department.getUserCreated())
                ).collect(Collectors.toList());
        return APIResponse.builder().status(true).statusText(MessageState.SUCESSO).details(departmentDTOS).build();

    }



}




