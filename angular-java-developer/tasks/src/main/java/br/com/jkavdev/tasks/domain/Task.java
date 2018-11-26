package br.com.jkavdev.tasks.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
public class Task {

    private Long id;

    private String name;

    @JsonFormat(pattern = "MM/dd/yyyy")
    private LocalDate dueDate;

    private Boolean completed;

}
