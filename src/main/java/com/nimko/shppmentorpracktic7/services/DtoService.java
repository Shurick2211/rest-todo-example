package com.nimko.shppmentorpracktic7.services;

import com.nimko.shppmentorpracktic7.dto.ToDoDto;
import com.nimko.shppmentorpracktic7.models.ToDoEntity;
import org.springframework.stereotype.Service;

@Service
public class DtoService {
    public ToDoDto getDtoFromEntity(ToDoEntity entity){
        return new ToDoDto(entity.getToDo(), entity.getPlannedDateTime(), entity.getState());
    }

    public ToDoEntity getEntityFromDto(ToDoDto dto){
        return new ToDoEntity(dto.getToDo(), dto.getPlannedDateTime(), dto.getState());
    }

}
