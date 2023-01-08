package com.nimko.shppmentorpracktic7.models;

import com.nimko.shppmentorpracktic7.utils.State;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Schema(name = "Схема ToDoEntity", description = "Сутність для Бази Даних, вона ж DTO")
public class ToDoEntity {
    @Id
    private String toDo;
    @Future(message = "{todo.future}")
    private LocalDateTime plannedDateTime;
    @NotNull
    private State state;

}
