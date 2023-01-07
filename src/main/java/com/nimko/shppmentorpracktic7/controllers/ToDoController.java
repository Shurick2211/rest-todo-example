package com.nimko.shppmentorpracktic7.controllers;

import com.nimko.shppmentorpracktic7.models.ToDoEntity;
import com.nimko.shppmentorpracktic7.services.ToDoService;
import com.nimko.shppmentorpracktic7.utils.ToDoable;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/todos")
@OpenAPIDefinition (info =
    @Info(
            title = "${api.description}",
            version = "${api.ver}",
            description = "My API",
            contact = @Contact(name = "Shurick", email = "shurick2211@gmail.com")
    )
)
@Tag(name = "Controller",description = "My ToDo Controller")
public class ToDoController implements ToDoable {

    private final ToDoService toDoService;

    @Autowired
    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping
    @Override
    @Operation(summary = "Get all ToDo")
    public ResponseEntity<?> getAll(){
        return toDoService.getAll();
    }

    @GetMapping("/{todo}")
    @Override
    @Operation(summary = "Get ToDo by todo-field")
    public ResponseEntity<?> getOne(@PathVariable String todo){
        return toDoService.getOne(todo);
    }

    @PostMapping
    @Override
    @Operation(summary = "Method for create ToDo")
    public ResponseEntity<?> createOne(@Valid @RequestBody ToDoEntity toDoEntity){
        return toDoService.createOne(toDoEntity);
    }

    @PutMapping
    @Override
    @Operation(summary = "Method for change ToDo")
    public ResponseEntity<?> putOne(@Valid @RequestBody ToDoEntity toDoEntity){
        return toDoService.putOne(toDoEntity);
    }

    @DeleteMapping("/{todo}")
    @Override
    @Operation(summary = "Method for delete ToDo")
    public ResponseEntity<?> deleteOne(@PathVariable String todo){
        return toDoService.deleteOne(todo);
    }

}
