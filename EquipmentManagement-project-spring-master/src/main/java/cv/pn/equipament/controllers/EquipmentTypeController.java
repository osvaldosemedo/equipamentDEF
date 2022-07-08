package cv.pn.equipament.controllers;


import cv.pn.equipament.dtos.DomainDTO;
import cv.pn.equipament.dtos.EquipmentTypeDTO;
import cv.pn.equipament.services.implementation.DomainServiceImpl;
import cv.pn.equipament.services.implementation.EquipmentTypeServiceImpl;
import cv.pn.equipament.utilities.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/equipmentType")
public class EquipmentTypeController {

    private final EquipmentTypeServiceImpl equipmentTypeService;


    public EquipmentTypeController(EquipmentTypeServiceImpl equipmentTypeService) {
        this.equipmentTypeService = equipmentTypeService;
    }

    @PostMapping(value = "/save", produces = {"application/vnd.defpn.app-v1.0+json"})
    @ResponseStatus(code = HttpStatus.CREATED)

    public ResponseEntity<Object> insertEquipmentType(@Valid @RequestBody EquipmentTypeDTO equipmentTypeDTO) {
        APIResponse response = equipmentTypeService.insertEquipmentType(equipmentTypeDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping(value = "/update/{id}", produces = {"application/vnd.nidef.app-v1.0+json"})
    @ResponseStatus(code = HttpStatus.ACCEPTED)

    public ResponseEntity<Object> updateEquipmentType(@PathVariable("id") String id, @Valid @RequestBody EquipmentTypeDTO equipmentTypeDTO) {
        APIResponse response = equipmentTypeService.updateEquipmentType(id, equipmentTypeDTO);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @GetMapping("/detail/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<Object> detailDomain(@PathVariable("id") String id) {
        APIResponse response = equipmentTypeService.getEquipmentType(id);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @GetMapping("/list/{selfId}")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<Object> listDomain(@PathVariable("selfId") String id) {
        APIResponse response = equipmentTypeService.getAllEquipmentType(id);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}