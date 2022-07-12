package cv.pn.equipament.services.implementation;

import cv.pn.equipament.dtos.EmployeeDTO;
import cv.pn.equipament.models.Employee;
import cv.pn.equipament.repositories.EmployeeRepository;

import cv.pn.equipament.services.EmployeeService;
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
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;


    @Override
    public APIResponse insertEmployee(EmployeeDTO employeeDTO) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeDTO.getId());
        if (!optionalEmployee.isEmpty()) {
            return APIResponse.builder().status(false).statusText(MessageState.ERRO_DE_INSERCAO).details(Arrays.asList("Funcionario ")).build();

        }

        Employee employee = new Employee();
        try {
            employee.setName(employeeDTO.getName());
            employee.setFunction(employeeDTO.getFunction());
            employee.setPatent(employeeDTO.getPatent());
            employee.setDmTypeUser(employeeDTO.getDmTypeUser());


            employeeRepository.save(employee);
            return APIResponse.builder().status(true).statusText(MessageState.INSERIDO_COM_SUCESSO).build();
        } catch (Exception e) {
            return APIResponse.builder().status(false).statusText(MessageState.ERRO_DE_INSERCAO).details(Arrays.asList(e.getMessage())).build();

        }

    }

    @Override
    public APIResponse updateEmployee(String id, EmployeeDTO employeeDTO) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isEmpty()) {
            return APIResponse.builder().status(false).statusText(MessageState.ERRO_AO_ATUALIZAR).details(Arrays.asList("Funcionario " + MessageState.ID_NAO_EXISTE)).build();

        }
        Employee employee = optionalEmployee.get();
        try {
          employee.setName(employeeDTO.getName());
          employee.setFunction(employeeDTO.getFunction());
          employee.setPatent(employeeDTO.getPatent());
          employee.setDmTypeUser(employeeDTO.getDmTypeUser());

        employeeRepository.save(employee);
        return APIResponse.builder().status(true).statusText(MessageState.ATUALIZADO_COM_SUCESSO).build();
    } catch(
    Exception e)

    {
        return APIResponse.builder().status(false).statusText(MessageState.ERRO_AO_ATUALIZAR).details(Arrays.asList(e.getMessage())).build();

    }

}

    @Override
    public APIResponse getEmployee(String id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if(!optionalEmployee.isPresent()){
            return APIResponse.builder().status(false).statusText(MessageState.ERRO).details(Arrays.asList("Funcionario " + MessageState.ID_NAO_EXISTE)).build();
        }
        Employee employee = optionalEmployee.get();



        try {
            EmployeeDTO employeeDTO = new EmployeeDTO();

            employeeDTO.setName(employee.getName());
            employeeDTO.setFunction(employee.getFunction());
            employeeDTO.setPatent(employee.getPatent());
            employeeDTO.setDmTypeUser(employee.getDmTypeUser());


        return APIResponse.builder().status(true).statusText(MessageState.SUCESSO).details(Arrays.asList(employeeDTO)).build();

    } catch (Exception e) {
        return APIResponse.builder().status(false).statusText(MessageState.ERRO).details(Arrays.asList(e.getMessage())).build();
    }

}

    @Override
    public APIResponse getAllEmployee(String dmTypeUser) {
        List<Employee> employees = employeeRepository.findByDmTypeUser(dmTypeUser);

        /*List<Object> employeesDTOS = employees.stream()
                .map(employee -> new EmployeeDTO(employee.getId(), employee.getName(),employee.getFunction(),employee.getPatent(),employee.getDmTypeUser())
                ).collect(Collectors.toList());*/
        return APIResponse.builder().status(true).statusText(MessageState.SUCESSO).build();

    }
}
