package cv.pn.equipament.services;

import cv.pn.equipament.dtos.DepartmentDTO;

import cv.pn.equipament.models.Department;
import cv.pn.equipament.utilities.APIResponse;


public interface DepartmentService {

    APIResponse insertDepartment(DepartmentDTO departmentDTO);
    APIResponse updateDepartment(String id, DepartmentDTO departmentDTO);
    APIResponse getDepartment(String id);
    APIResponse getAllDepartment(String selfId);
}
