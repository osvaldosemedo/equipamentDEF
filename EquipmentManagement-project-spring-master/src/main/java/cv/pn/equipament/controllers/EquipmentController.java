package cv.pn.equipament.controllers;



import cv.pn.equipament.dtos.EquipmentDTO;

import cv.pn.equipament.services.implementation.EquipmentServiceImpl;
import cv.pn.equipament.utilities.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/equipment")
public class EquipmentController {

    private final EquipmentServiceImpl equipmentService;
    public EquipmentController(EquipmentServiceImpl equipmentService) {
        this.equipmentService = equipmentService;
    }


    @PostMapping(value = "/save", produces = {"application/vnd.defpn.app-v1.0+json"})
    @ResponseStatus(code = HttpStatus.CREATED)

    public ResponseEntity<Object> insertDepartment(@Valid @RequestBody EquipmentDTO equipmentDTO) {
        APIResponse response = equipmentService.insertEquipment(equipmentDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);


    }
}