package me.dio.controller;

import me.dio.domain.Resident;
import me.dio.service.ResidentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/residents")
public class ResidentController {

    private final ResidentService residentService;


    public ResidentController(ResidentService residentService) {
        this.residentService = residentService;
    }

    //Aprimorar com DTO
    @GetMapping("/{id}")
    public ResponseEntity<Resident> findById(@PathVariable Long id){
        var resident = residentService.findByIdResident(id);
        return ResponseEntity.ok(resident);
    }

    @PostMapping
    public ResponseEntity<Resident> createToResident(@RequestBody Resident resident){
    var residentCreated = residentService.createToResident(resident);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(resident.getId())
                .toUri();
    return ResponseEntity.created(location).body(residentCreated);
    }



}
