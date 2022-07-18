package cv.pn.equipament.controllers;

import cv.pn.equipament.dtos.DepartmentDTO;
import cv.pn.equipament.models.Department;
import cv.pn.equipament.services.implementation.DepartmentServiceImpl;
import cv.pn.equipament.utilities.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/department")
public class DepartmentController {


    private final DepartmentServiceImpl departmentService;

    public DepartmentController(DepartmentServiceImpl departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping(value = "/save", produces = {"application/vnd.defpn.app-v1.0+json"})
    @ResponseStatus(code = HttpStatus.CREATED)

    public ResponseEntity<Object> insertDepartment(@Valid @RequestBody DepartmentDTO departmentDTO) {
        APIResponse response = departmentService.insertDepartment(departmentDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @PutMapping(value = "/update/{id}", produces = {"application/vnd.nidef.app-v1.0+json"})
    @ResponseStatus(code = HttpStatus.ACCEPTED)

    public ResponseEntity<Object> updateDepartment(@PathVariable("id") String id, @Valid @RequestBody DepartmentDTO departmentDTO) {
        APIResponse response = departmentService.updateDepartment(id, departmentDTO);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @GetMapping("/detail/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<Object> detailDepartment(@PathVariable("id") String id) {
        APIResponse response = departmentService.getDepartment(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/list/{selfId}")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<Object> listDepartment(@PathVariable("selfId") String id) {
        APIResponse response = departmentService.getAllDepartment(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

