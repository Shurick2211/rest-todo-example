package com.nimko.shppmentorpracktic7.services;

import com.nimko.shppmentorpracktic7.dto.ToDoDto;
import com.nimko.shppmentorpracktic7.models.ToDoEntity;
import com.nimko.shppmentorpracktic7.models.User;
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


    @Autowired
    public ToDoService(ToDoRepository toDoRepository, StateService stateService,
                       MessageSource messageSource) {
        this.toDoRepository = toDoRepository;
        this.stateService = stateService;
        this.messageSource = messageSource;
    }

    @Override
    public ResponseEntity<?> getAll(User user) {
        List<ToDoDto> dtos = toDoRepository.findAllByUser(user).stream()
                .map(DtoService::getDtoFromEntity).collect(Collectors.toList());
        return ResponseEntity.ok().body(dtos);
    }

    @Override
    public ResponseEntity<?> getOne(Long id, User user) {
        return ResponseEntity.ok()
                .body(DtoService.getDtoFromEntity(
                        toDoRepository.findToDoEntityByIdAndUser(id,user).orElseThrow()));
    }

    @Override
    public ResponseEntity<?> createOne(ToDoDto dto, User user, Locale locale) {
        ToDoEntity toDoEntity = DtoService.getEntityFromDto(dto);
        if (toDoRepository.findByToDo(toDoEntity.getToDo()).isEmpty() && toDoEntity.getState() != State.PLANNED)
            throw new NoSuchElementException(
                    messageSource.getMessage("operation.first", null, locale));
        toDoEntity.setUser(user);
        toDoRepository.save(toDoEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                DtoService.getDtoFromEntity(toDoEntity));
    }

    @Override
    public ResponseEntity<?> putOne(ToDoDto dto, User user, Locale locale) {
        ToDoEntity toDoEntity = DtoService.getEntityFromDto(dto);
        toDoEntity.setUser(user);
        ToDoEntity oldEntity = toDoRepository.
                findToDoEntityByUserAndToDo(user,dto.getToDo()).orElseThrow();
        toDoEntity = stateService.getUpdate(oldEntity,toDoEntity);
        if (toDoEntity == null ) throw new NoSuchElementException(
                messageSource.getMessage("operation.null",null, locale));
        toDoEntity.setId(oldEntity.getId());
        toDoRepository.save(toDoEntity);
        return ResponseEntity.ok().body(
                DtoService.getDtoFromEntity(toDoEntity));
    }

    @Override
    public ResponseEntity<?> deleteOne(Long id, User user, Locale locale) {
        ToDoEntity toDoEntity = toDoRepository.findToDoEntityByIdAndUser(id,user).orElseThrow();
        toDoRepository.delete(toDoEntity);
        return ResponseEntity.ok().body(DtoService.getDtoFromEntity(toDoEntity));
    }
}
