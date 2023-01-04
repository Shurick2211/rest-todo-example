package com.nimko.shppmentorpracktic7.services;

import com.nimko.shppmentorpracktic7.models.ToDoEntity;
import com.nimko.shppmentorpracktic7.utils.ToDoable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ToDoService implements ToDoable {
    @Override
    public ResponseEntity<?> getAll() {
        return null;
    }

    @Override
    public ResponseEntity<?> getOne(String todo) {
        return ResponseEntity.ok().body("");
    }

    @Override
    public ResponseEntity<?> createOne(@RequestBody ToDoEntity toDoEntity) {
        return ResponseEntity.ok().body("");
    }

    @Override
    public ResponseEntity<?> putOne(@RequestBody ToDoEntity toDoEntity) {
        return ResponseEntity.ok().body("");
    }

    @Override
    public ResponseEntity<?> deleteOne(String todo) {
        return ResponseEntity.ok().body("");
    }
}
