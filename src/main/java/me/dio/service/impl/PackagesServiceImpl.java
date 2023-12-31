package me.dio.service.impl;

import me.dio.domain.Packages;
import me.dio.domain.repository.PackagesRepository;
import me.dio.service.PackagesService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
@Service
public class PackagesServiceImpl implements PackagesService {

    private final PackagesRepository packageRepository;

    public PackagesServiceImpl(PackagesRepository packageRepository) {
        this.packageRepository = packageRepository;
    }
    @Override
    public Packages findByIdPackages(Long id) {
        return packageRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Packages createToPackages(Packages residentToCreate) {
        return packageRepository.save(residentToCreate);
    }

    @Override
    public void delete(Long id) {
        Packages encomenda = this.findByIdPackages(id);
        this.packageRepository.delete(encomenda);
    }
}
