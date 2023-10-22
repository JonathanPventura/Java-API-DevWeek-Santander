package me.dio.service.impl;

import me.dio.domain.Resident;
import me.dio.domain.repository.ResidentRepository;
import me.dio.service.ResidentService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ResidentServiceImpl implements ResidentService {

    //Usamos esse contrutor para que o Spring entenda para criamos o
    //componente de servico ele precise ejetar esse respository
    private final ResidentRepository residentRepository;

    public ResidentServiceImpl(ResidentRepository residentRepository) {
        this.residentRepository = residentRepository;
    }

    @Override
    public Resident findByIdResident(Long id) {
        return residentRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Resident createToResident(Resident residentToCreate) {

        if (residentToCreate.getId() != ' ' && residentRepository.existsById(residentToCreate.getId())){
            throw new IllegalStateException("This resident CPF is already exists.");
        }

        return residentRepository.save(residentToCreate);
    }

    @Override
    public void delete(Long id) {
        Resident resident = findByIdResident(id);
        this.residentRepository.delete(resident);

    }

    @Override
    public Resident atualizarResident(Long id, Resident atualizarResident) {
        Resident dbResident = this.findByIdResident(id);

        dbResident.setName(atualizarResident.getName());
        dbResident.setEmail(atualizarResident.getEmail());
        dbResident.setBloco(atualizarResident.getBloco());
        dbResident.setApartamento(atualizarResident.getApartamento());
        dbResident.setPhone(atualizarResident.getPhone());
        return this.residentRepository.save(dbResident);
    }


}
