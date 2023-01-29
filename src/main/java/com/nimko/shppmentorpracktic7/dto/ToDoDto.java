package com.nimko.shppmentorpracktic7.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nimko.shppmentorpracktic7.utils.State;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@ToString
@Schema(name = "Схема ToDoDto", description = "DTO для фронтенду!")
public class ToDoDto {
    long id;
    @NotNull
    @NotEmpty
    private String toDo;
    @NotNull
    @Future
    private LocalDateTime plannedDateTime;
    @NotNull
    private State state;
    @JsonProperty("id")
    public long getId() {
        return id;
    }

    @JsonProperty("to_do")
    public String getToDo() {
        return toDo;
    }

    @JsonProperty("planned_date_time")
    public LocalDateTime getPlannedDateTime() {
        return plannedDateTime;
    }

    @JsonProperty("state")
    public State getState() {
        return state;
    }

}
