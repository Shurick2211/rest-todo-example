package com.nimko.shppmentorpracktic7.services;

import com.nimko.shppmentorpracktic7.dto.ToDoDto;
import com.nimko.shppmentorpracktic7.models.ToDoEntity;
import com.nimko.shppmentorpracktic7.repo.ToDoRepository;
import com.nimko.shppmentorpracktic7.utils.State;
import com.nimko.shppmentorpracktic7.utils.ToDoable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class ToDoService implements ToDoable {
    private final ToDoRepository toDoRepository;
    private final StateService stateService;
    private final MessageSource messageSource;
    private final DtoService dtoService;

    @Autowired
    public ToDoService(ToDoRepository toDoRepository, StateService stateService,
                       MessageSource messageSource, DtoService dtoService) {
        this.toDoRepository = toDoRepository;
        this.stateService = stateService;
        this.messageSource = messageSource;
        this.dtoService = dtoService;
    }

    @Override
    public ResponseEntity<?> getAll() {
        List<ToDoDto> dtos = toDoRepository.findAll().stream()
                .map(dtoService::getDtoFromEntity).collect(Collectors.toList());
        return ResponseEntity.ok().body(dtos);
    }

    @Override
    public ResponseEntity<?> getOne(String todo) {
        return ResponseEntity.ok()
                .body(dtoService.getDtoFromEntity(toDoRepository.findById(todo).orElseThrow()));
    }

    @Override
    public ResponseEntity<?> createOne(ToDoDto dto, Locale locale) {
        ToDoEntity toDoEntity = dtoService.getEntityFromDto(dto);
        if (toDoRepository.findById(toDoEntity.getToDo()).isEmpty() && toDoEntity.getState() != State.PLANNED)
            throw new NoSuchElementException(
                    messageSource.getMessage("operation.first", null, locale));
        toDoRepository.save(toDoEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                messageSource.getMessage("create.sms", null, locale)
                        + dtoService.getDtoFromEntity(toDoEntity));
    }

    @Override
    public ResponseEntity<?> putOne(ToDoDto dto, Locale locale) {
        ToDoEntity toDoEntity = dtoService.getEntityFromDto(dto);
        ToDoEntity oldEntity = toDoRepository.
                findById(toDoEntity.getToDo()).orElseThrow();
        toDoEntity = stateService.getUpdate(oldEntity,toDoEntity);
        if (toDoEntity == null) throw new NoSuchElementException(
                messageSource.getMessage("operation.null",null, locale));
        toDoRepository.save(toDoEntity);
        return ResponseEntity.ok().body(
                messageSource.getMessage("put.sms", null, locale)
                        + dtoService.getDtoFromEntity(toDoEntity));
    }

    @Override
    public ResponseEntity<?> deleteOne(String todo, Locale locale) {
        ToDoEntity toDoEntity = toDoRepository.findById(todo).orElseThrow();
        toDoRepository.delete(toDoEntity);
        return ResponseEntity.ok().body(dtoService.getDtoFromEntity(toDoEntity) + " "
                + messageSource.getMessage("delete.sms", null, locale));
    }
}
