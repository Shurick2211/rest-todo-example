package com.nimko.shppmentorpracktic7.models;

import com.nimko.shppmentorpracktic7.utils.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class ToDoEntity {
    @Id
    private String toDo;
    private LocalDateTime plannedDateTime;
    private State state;
}
