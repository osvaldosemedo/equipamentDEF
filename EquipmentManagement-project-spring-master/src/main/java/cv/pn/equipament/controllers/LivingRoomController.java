package cv.pn.equipament.controllers;

import cv.pn.equipament.dtos.EquipmentTypeDTO;
import cv.pn.equipament.dtos.LivingRoomDTO;
import cv.pn.equipament.services.implementation.LivingRoomServiceImpl;
import cv.pn.equipament.utilities.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/livingRoom")
public class LivingRoomController {

    private final LivingRoomServiceImpl livingRoomService;

    public LivingRoomController(LivingRoomServiceImpl livingRoomService) {
        this.livingRoomService = livingRoomService;
    }

    @PostMapping(value = "/save", produces = {"application/vnd.defpn.app-v1.0+json"})
    @ResponseStatus(code = HttpStatus.CREATED)

    public ResponseEntity<Object> insertLivingRoom(@Valid @RequestBody LivingRoomDTO livingRoomDTO) {
        APIResponse response = livingRoomService.insertLivingRoom(livingRoomDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping(value = "/update/{id}", produces = {"application/vnd.nidef.app-v1.0+json"})
    @ResponseStatus(code = HttpStatus.ACCEPTED)

    public ResponseEntity<Object> updateLivingRoom(@PathVariable("id") String id, @Valid @RequestBody LivingRoomDTO livingRoomDTO) {
        APIResponse response = livingRoomService.updateLivingRoom(id, livingRoomDTO);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @GetMapping("/detail/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<Object> detailLivingRoom(@PathVariable("id") String id) {
        APIResponse response = livingRoomService.getLivingRoom(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

        @GetMapping("/list")
        @ResponseStatus(code = HttpStatus.OK)
        public ResponseEntity<Object> listLivingRoom() {
            APIResponse response = livingRoomService.getAllLivingRoom();
            return new ResponseEntity<>(response, HttpStatus.OK);
}}