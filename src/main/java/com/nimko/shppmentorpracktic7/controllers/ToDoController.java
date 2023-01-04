package com.nimko.shppmentorpracktic7.controllers;

import com.nimko.shppmentorpracktic7.models.ToDoEntity;
import com.nimko.shppmentorpracktic7.services.ToDoService;
import com.nimko.shppmentorpracktic7.utils.ToDoable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class ToDoController implements ToDoable {

    private final ToDoService toDoService;

    @Autowired
    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping
    @Override
    public ResponseEntity<?> getAll(){
        return toDoService.getAll();
    }

    @GetMapping("/{todo}")
    @Override
    public ResponseEntity<?> getOne(@PathVariable String todo){
        return toDoService.getOne(todo);
    }

    @PostMapping
    @Override
    public ResponseEntity<?> createOne(@RequestBody ToDoEntity toDoEntity){
        return toDoService.createOne(toDoEntity);
    }

    @PutMapping
    @Override
    public ResponseEntity<?> putOne(@RequestBody ToDoEntity toDoEntity){
        return toDoService.putOne(toDoEntity);
    }

    @DeleteMapping("/{todo}")
    @Override
    public ResponseEntity<?> deleteOne(@PathVariable String todo){
        return toDoService.deleteOne(todo);
    }

}
