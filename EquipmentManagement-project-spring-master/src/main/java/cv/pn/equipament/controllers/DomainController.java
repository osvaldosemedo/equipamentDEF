package cv.pn.equipament.controllers;


import cv.pn.equipament.dtos.DomainDTO;
import cv.pn.equipament.services.implementation.DomainServiceImpl;
import cv.pn.equipament.utilities.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/domain")
public class DomainController {


    private final DomainServiceImpl domainService;

    public DomainController(DomainServiceImpl domainService) {
        this.domainService = domainService;
    }


    @PostMapping(value = "/save", produces = {"application/vnd.defpn.app-v1.0+json"})
    @ResponseStatus(code = HttpStatus.CREATED)

    public ResponseEntity<Object> insertDepartment(@Valid @RequestBody DomainDTO domainDTO) {
        APIResponse response = domainService.insertDomain(domainDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);


    }


    @PutMapping(value = "/update/{id}", produces = {"application/vnd.nidef.app-v1.0+json"})
    @ResponseStatus(code = HttpStatus.ACCEPTED)

    public ResponseEntity<Object> updateDomain(@PathVariable("id") String id, @Valid @RequestBody DomainDTO domainDTO) {
        APIResponse response = domainService.updateDomain(id, domainDTO);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @GetMapping("/detail/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<Object> detailDomain(@PathVariable("id") String id) {
        APIResponse response = domainService.getDomain(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/list/{selfId}")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity <Object> listDomain(@PathVariable("selfId")String id) {
        APIResponse response = domainService.getAllDomain(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
