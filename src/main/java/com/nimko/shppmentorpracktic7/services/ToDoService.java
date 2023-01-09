package com.nimko.shppmentorpracktic7.services;

import com.nimko.shppmentorpracktic7.models.ToDoEntity;
import com.nimko.shppmentorpracktic7.repo.ToDoRepository;
import com.nimko.shppmentorpracktic7.utils.State;
import com.nimko.shppmentorpracktic7.utils.ToDoable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.LocaleResolver;

import java.util.Locale;
import java.util.NoSuchElementException;

@Service
@Slf4j
public class ToDoService implements ToDoable {
    private final ToDoRepository toDoRepository;
    private final StateService stateService;

    private final MessageSource messageSource;

    @Autowired
    public ToDoService(ToDoRepository toDoRepository, StateService stateService, MessageSource messageSource) {
        this.toDoRepository = toDoRepository;
        this.stateService = stateService;
        this.messageSource = messageSource;
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
    public ResponseEntity<?> createOne(ToDoEntity toDoEntity, Locale locale) {
        if (toDoRepository.findById(toDoEntity.getToDo()).isEmpty() && toDoEntity.getState() != State.PLANNED)
            throw new NoSuchElementException(messageSource.getMessage("operation.first", null, locale));
        toDoRepository.save(toDoEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body("Create: " + toDoEntity);
    }

    @Override
    public ResponseEntity<?> putOne(ToDoEntity toDoEntity, Locale locale) {
        ToDoEntity oldEntity = toDoRepository.
                findById(toDoEntity.getToDo()).orElseThrow();
        toDoEntity = stateService.getUpdate(oldEntity,toDoEntity);
        //need check of null
        toDoRepository.save(toDoEntity);
        return ResponseEntity.ok().body("Put " + toDoEntity);
    }

    @Override
    public ResponseEntity<?> deleteOne(String todo) {
        ToDoEntity toDoEntity = toDoRepository.findById(todo).orElseThrow();
        toDoRepository.delete(toDoEntity);
        return ResponseEntity.ok().body(toDoEntity + " was deleted!");
    }
}
