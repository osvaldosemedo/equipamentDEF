package cv.pn.equipament.services;

import cv.pn.equipament.dtos.EmployeeDTO;
import cv.pn.equipament.utilities.APIResponse;

public interface EmployeeService {
    APIResponse insertEmployee(EmployeeDTO employeeDTO);
    APIResponse updateEmployee(String id, EmployeeDTO employeeDTO);
    APIResponse getEmployee(String id);
    APIResponse getAllEmployee();
}
