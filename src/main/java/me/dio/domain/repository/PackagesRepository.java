package me.dio.domain.repository;

import me.dio.domain.Packages;
import me.dio.domain.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PackagesRepository extends JpaRepository<Packages, Long> {
}
