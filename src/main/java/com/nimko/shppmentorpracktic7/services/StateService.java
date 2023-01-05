package com.nimko.shppmentorpracktic7.services;

import com.nimko.shppmentorpracktic7.models.ToDoEntity;
import com.nimko.shppmentorpracktic7.utils.State;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StateService {

    public ToDoEntity getUpdate(ToDoEntity oldEntity, ToDoEntity newEntity){
        State oldState = oldEntity.getState();
        State newState = newEntity.getState();
        if(oldState == State.CANCELED || oldState == State.DONE) throw new NoSuchElementException();
        return newState != State.CANCELED && oldState != newState
                ? stateTransition(oldEntity, newEntity).orElseThrow() : newEntity;
    }

    private Optional<ToDoEntity> stateTransition(ToDoEntity oldEntity, ToDoEntity newEntity) {
        List<State> states = Arrays.stream(State.values()).collect(Collectors.toList());
        State exeptedState = states.get(states.indexOf(oldEntity.getState()) + 1);
        return exeptedState == newEntity.getState()  ? Optional.of(newEntity) : Optional.empty();
    }
}
