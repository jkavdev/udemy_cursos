package br.com.jkavdev.tasks.service;

import br.com.jkavdev.tasks.domain.Task;

public interface TaskService {

    Iterable<Task> list();

    Task save(Task task);

}
