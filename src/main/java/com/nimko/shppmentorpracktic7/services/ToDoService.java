package com.nimko.shppmentorpracktic7.services;

import com.nimko.shppmentorpracktic7.models.ToDoEntity;
import com.nimko.shppmentorpracktic7.repo.ToDoRepository;
import com.nimko.shppmentorpracktic7.utils.State;
import com.nimko.shppmentorpracktic7.utils.ToDoable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

@Service
public class ToDoService implements ToDoable {
    private final ToDoRepository toDoRepository;
    private final StateService stateService;

    @Autowired
    public ToDoService(ToDoRepository toDoRepository, StateService stateService) {
        this.toDoRepository = toDoRepository;
        this.stateService = stateService;
    }

    @Override
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok()
                .body(toDoRepository.findAll());
    }

    @Override
    public ResponseEntity<?> getOne(String todo) {
        return ResponseEntity.ok().body(toDoRepository.findById(todo));
    }

    @Override
    public ResponseEntity<?> createOne(ToDoEntity toDoEntity) {
        if (toDoEntity.getState() != State.PLANNED) throw new NotFoundException("First STATE must be PLANNED!");
        toDoRepository.save(toDoEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body("Create: " + toDoEntity);
    }

    @Override
    public ResponseEntity<?> putOne(ToDoEntity toDoEntity) {
        ToDoEntity oldEntity = toDoRepository.findById(toDoEntity.getToDo()).orElseThrow();
        toDoRepository.save(stateService.getUpdate(oldEntity,toDoEntity));
        return ResponseEntity.ok().body("");
    }

    @Override
    public ResponseEntity<?> deleteOne(String todo) {
        ToDoEntity toDoEntity = toDoRepository.findById(todo).orElseThrow();
        toDoRepository.delete(toDoEntity);
        return ResponseEntity.ok().body(toDoEntity + "was deleted!");
    }
}
