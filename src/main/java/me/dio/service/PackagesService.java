package me.dio.service;

import me.dio.domain.Packages;

public interface PackagesService {

    Packages findByIdPackages(Long id);

    Packages createToPackages(Packages residentToCreate);
}
