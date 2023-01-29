package com.nimko.shppmentorpracktic7.repo;

import com.nimko.shppmentorpracktic7.models.ToDoEntity;
import com.nimko.shppmentorpracktic7.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ToDoRepository extends JpaRepository<ToDoEntity,Long> {
    Optional<ToDoEntity> findByToDo(String toDo);
    Optional<ToDoEntity> findToDoEntityByUserAndToDo(User user, String toDo);

    List<ToDoEntity> findAllByUser(User user);
    Optional<ToDoEntity> findToDoEntityByIdAndUser(Long id, User user);

}
