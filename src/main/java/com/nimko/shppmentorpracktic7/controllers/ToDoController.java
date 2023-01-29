package com.nimko.shppmentorpracktic7.controllers;

import com.nimko.shppmentorpracktic7.dto.ToDoDto;
import com.nimko.shppmentorpracktic7.models.User;
import com.nimko.shppmentorpracktic7.services.ToDoService;
import com.nimko.shppmentorpracktic7.utils.ToDoable;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Locale;

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
@SecurityRequirement(name="user-admin")
public class ToDoController implements ToDoable {
    private final ToDoService toDoService;

    @Autowired
    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping
    @Override
    @Operation(summary = "Get all ToDo", description = "В цьому методі можна отримати всі ToDo")
    public ResponseEntity<?> getAll(@AuthenticationPrincipal User user){
        return toDoService.getAll(user);
    }

    @GetMapping("/{id}")
    @Override
    @Operation(summary = "Get ToDo by todo-field", description = "В цьому методі можна отримати один ToDo по полю - todo")
    public ResponseEntity<?> getOne(@PathVariable Long id,
                                    @AuthenticationPrincipal User user){
        return toDoService.getOne(id, user);
    }

    @PostMapping
    @Override
    @Operation(summary = "Method for create ToDo", description = "Тут створюємо ToDo"
    )
    public ResponseEntity<?> createOne(@Valid @RequestBody ToDoDto dto,
                                       @AuthenticationPrincipal User user,
                                       Locale locale){
        return toDoService.createOne(dto, user, locale);
    }

    @PutMapping
    @Override
    @Operation(summary = "Method for change ToDo", description = "Тут змінюємо ToDo")
    public ResponseEntity<?> putOne(@Valid @RequestBody ToDoDto dto,
                                    @AuthenticationPrincipal User user,
                                    Locale locale){
        return toDoService.putOne(dto, user, locale);
    }

    @DeleteMapping("/{id}")
    @Override
    @Operation(summary = "Method for delete ToDo", description = "Для видалення ToDo")
    public ResponseEntity<?> deleteOne(@PathVariable Long id,
                                       @AuthenticationPrincipal User user,
                                       Locale locale){
        return toDoService.deleteOne(id, user, locale);
    }

}
