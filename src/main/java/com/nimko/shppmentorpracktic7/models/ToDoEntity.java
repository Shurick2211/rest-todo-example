package com.nimko.shppmentorpracktic7.models;

import com.nimko.shppmentorpracktic7.utils.State;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class ToDoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    private String toDo;
    private LocalDateTime plannedDateTime;
    private State state;
    @ManyToOne
    @JoinColumn(name = "user_login")
    private User user;

    public ToDoEntity(String toDo, LocalDateTime plannedDateTime, State state) {
        this.toDo = toDo;
        this.plannedDateTime = plannedDateTime;
        this.state = state;
    }
}
