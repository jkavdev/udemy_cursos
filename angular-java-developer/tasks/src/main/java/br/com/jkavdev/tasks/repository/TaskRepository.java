package br.com.jkavdev.tasks.repository;

import br.com.jkavdev.tasks.domain.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long> {
}
