package me.dio.service.impl;

import me.dio.domain.Tasks;
import me.dio.domain.repository.TasksRepository;
import me.dio.service.TasksService;

import java.util.NoSuchElementException;

public class TasksServiceImpl implements TasksService {

    private final TasksRepository tasksRepository;

    public TasksServiceImpl(TasksRepository tasksRepository) {

        this.tasksRepository = tasksRepository;
    }


    @Override
    public Tasks findByIdTasks(Long id) {
        return tasksRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Tasks createToTasks(Tasks residentToCreate) {
        return tasksRepository.save(residentToCreate);
    }
}
