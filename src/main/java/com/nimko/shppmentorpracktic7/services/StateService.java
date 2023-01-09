package com.nimko.shppmentorpracktic7.services;

import com.nimko.shppmentorpracktic7.models.ToDoEntity;
import com.nimko.shppmentorpracktic7.utils.State;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StateService {

    public ToDoEntity getUpdate(ToDoEntity oldEntity, ToDoEntity newEntity){
        State oldState = oldEntity.getState();
        State newState = newEntity.getState();
        if(oldState == State.CANCELED || oldState == State.DONE) return null;
        return newState != State.CANCELED && oldState != newState
                ? stateTransition(oldEntity, newEntity) : newEntity;
    }

    private ToDoEntity stateTransition(ToDoEntity oldEntity, ToDoEntity newEntity) {
        List<State> states = Arrays.stream(State.values()).collect(Collectors.toList());
        State exeptedState = states.get(states.indexOf(oldEntity.getState()) + 1);
        if(exeptedState != newEntity.getState()) newEntity = null;
        return newEntity;
    }
}
