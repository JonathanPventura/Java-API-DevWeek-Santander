package me.dio.service;


import me.dio.domain.Tasks;

public interface TasksService {

    Tasks findByIdTasks(Long id);

    Tasks createToTasks(Tasks residentToCreate);


    void delete(Long id);
}
