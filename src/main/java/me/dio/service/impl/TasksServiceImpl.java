package me.dio.service.impl;

import me.dio.domain.Tasks;
import me.dio.domain.repository.TasksRepository;
import me.dio.service.TasksService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
@Service
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

    @Override
    public void delete(Long id) {
        Tasks task = this.findByIdTasks(id);
        this.tasksRepository.delete(task);
    }


}
