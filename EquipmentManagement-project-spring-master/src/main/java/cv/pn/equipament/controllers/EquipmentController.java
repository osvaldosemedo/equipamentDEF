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

    public ResponseEntity<Object> insertEquipment(@Valid @RequestBody EquipmentDTO equipmentDTO) {
        APIResponse response = equipmentService.insertEquipment(equipmentDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);


    }

    @PutMapping(value = "/update", produces = {"application/vnd.nidef.app-v1.0+json"})
    @ResponseStatus(code = HttpStatus.ACCEPTED)

    public ResponseEntity<Object> updateEquipment( @Valid @RequestBody EquipmentDTO equipmentDTO) {
        APIResponse response = equipmentService.updateEquipment(equipmentDTO);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);

    }
    @GetMapping("/detail/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity <Object> detailEquipment(@PathVariable("id")String id) {
        APIResponse response = equipmentService.getEquipment(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/list")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity <Object> listEquipment () {
        APIResponse response = equipmentService.getALLEquipment();
        return new ResponseEntity<>(response, HttpStatus.OK);
}}