package me.dio.service;

import me.dio.domain.Resident;
import org.springframework.stereotype.Service;


public interface ResidentService {

    Resident findByIdResident(Long id);

    Resident createToResident(Resident residentToCreate);

    void delete(Long id);

    Resident atualizarResident(Long id,Resident atualizarResident);


}
