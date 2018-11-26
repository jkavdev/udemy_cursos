package br.com.jkavdev.tasks.service;

import br.com.jkavdev.tasks.domain.Task;
import br.com.jkavdev.tasks.repository.TaskRepository;

public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Iterable<Task> list() {
        return taskRepository.findAll();
    }
}
