package me.dio.service;

import me.dio.domain.Resident;
import org.springframework.stereotype.Service;


public interface ResidentService {

    Resident findByIdResident(Long id);

    Resident createToResident(Resident residentToCreate);



}
