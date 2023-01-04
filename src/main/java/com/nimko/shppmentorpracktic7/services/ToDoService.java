package com.nimko.shppmentorpracktic7.services;

import com.nimko.shppmentorpracktic7.models.ToDoEntity;
import com.nimko.shppmentorpracktic7.repo.ToDoRepository;
import com.nimko.shppmentorpracktic7.utils.State;
import com.nimko.shppmentorpracktic7.utils.ToDoable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.webjars.NotFoundException;

@Service
public class ToDoService implements ToDoable {
    private final ToDoRepository toDoRepository;

    @Autowired
    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    @Override
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok()
                .body(toDoRepository.findAll());
    }

    @Override
    public ResponseEntity<?> getOne(String todo) {
        return ResponseEntity.ok().body(toDoRepository.findByToDo(todo));
    }

    @Override
    public ResponseEntity<?> createOne(@RequestBody ToDoEntity toDoEntity) {
        if (toDoEntity.getState() != State.PLANNED) throw new NotFoundException("First STATE must be PLANNED!");
        toDoRepository.save(toDoEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body("Create: " + toDoEntity);
    }

    @Override
    public ResponseEntity<?> putOne(@RequestBody ToDoEntity toDoEntity) {
        if(toDoRepository.findById(toDoEntity.getId()).isEmpty()) throw new NotFoundException("Todo is not exist!");
        toDoRepository.save(toDoEntity);
        return ResponseEntity.ok().body("");
    }

    @Override
    public ResponseEntity<?> deleteOne(String todo) {
        ToDoEntity toDoEntity = toDoRepository.findByToDo(todo);
        if(toDoEntity == null) throw new NotFoundException("Todo is not exist!");
        toDoRepository.delete(toDoEntity);
        return ResponseEntity.ok().body(toDoEntity + "was deleted!");
    }
}
