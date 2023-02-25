package com.nimko.shppmentorpracktic7.services;

import com.nimko.shppmentorpracktic7.dto.ToDoDto;
import com.nimko.shppmentorpracktic7.models.ToDoEntity;


public class DtoService {
    public static ToDoDto getDtoFromEntity(ToDoEntity entity){
        return new ToDoDto(entity.getId(), entity.getToDo(), entity.getPlannedDateTime(), entity.getState());
    }

    public static ToDoEntity getEntityFromDto(ToDoDto dto){
        return new ToDoEntity(dto.getToDo(), dto.getPlannedDateTime(), dto.getState());
    }

}
