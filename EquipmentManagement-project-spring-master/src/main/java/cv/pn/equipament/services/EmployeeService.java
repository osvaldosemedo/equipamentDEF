package cv.pn.equipament.services;

import cv.pn.equipament.dtos.EmployeeDTO;
import cv.pn.equipament.utilities.APIResponse;

public interface EmployeeSevice {
    APIResponse insertEmployee(EmployeeDTO employeeDTO);
    APIResponse updateEmployee(String id, EmployeeDTO employeeDTO);
    APIResponse getEmply
}
