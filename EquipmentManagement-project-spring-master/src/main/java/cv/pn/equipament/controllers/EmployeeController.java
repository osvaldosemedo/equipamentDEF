package cv.pn.equipament.controllers;



import cv.pn.equipament.dtos.EmployeeDTO;
import cv.pn.equipament.services.implementation.EmployeeServiceImpl;
import cv.pn.equipament.utilities.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }


    @PostMapping(value = "/save", produces = {"application/vnd.defpn.app-v1.0+json"})
    @ResponseStatus(code = HttpStatus.CREATED)

    public ResponseEntity<Object> insertEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
        APIResponse response = employeeService.insertEmployee(employeeDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @PutMapping(value = "/update/{id}", produces = {"application/vnd.nidef.app-v1.0+json"})
    @ResponseStatus(code = HttpStatus.ACCEPTED)

    public ResponseEntity<Object> updateEmployee(@PathVariable("id") String id, @Valid @RequestBody EmployeeDTO employeeDTO) {
        APIResponse response = employeeService.updateEmployee(id, employeeDTO);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @GetMapping("/detail/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity <Object> detailEmployee(@PathVariable("id")String id) {
        APIResponse response = employeeService.getEmployee(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
        @GetMapping("/list")
        @ResponseStatus(code = HttpStatus.OK)
        public ResponseEntity <Object> listEmployee(){
            APIResponse response = employeeService.getAllEmployee();
            return new ResponseEntity<>(response, HttpStatus.OK);
}}