package me.dio.controller;

import me.dio.domain.Packages;
import me.dio.service.PackagesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/packages")
public class PackagesController {

    private final PackagesService packagesService;

    public PackagesController(PackagesService packagesService) {
        this.packagesService = packagesService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Packages> findById(@PathVariable Long id){
        var pack = packagesService.findByIdPackages(id);
        return ResponseEntity.ok(pack);
    }

    @PostMapping
    public ResponseEntity<Packages> createToPackage(@RequestBody Packages packages){
        var packageCreate = packagesService.createToPackages(packages);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(packages.getId())
                .toUri();
        return ResponseEntity.created(location).body(packageCreate);
    }



}
