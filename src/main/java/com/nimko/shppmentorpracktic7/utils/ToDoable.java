package com.nimko.shppmentorpracktic7.utils;

import com.nimko.shppmentorpracktic7.models.ToDoEntity;
import org.springframework.http.ResponseEntity;

public interface ToDoable {
   ResponseEntity<?> getAll();
   ResponseEntity<?> getOne(String todo);
   ResponseEntity<?> createOne(ToDoEntity toDoEntity);
   ResponseEntity<?> putOne(ToDoEntity toDoEntity);
   ResponseEntity<?> deleteOne(String todo);
}
