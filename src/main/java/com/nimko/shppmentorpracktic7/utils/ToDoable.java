package com.nimko.shppmentorpracktic7.utils;

import com.nimko.shppmentorpracktic7.models.ToDoEntity;
import org.springframework.http.ResponseEntity;

import java.util.Locale;

public interface ToDoable {
   ResponseEntity<?> getAll();
   ResponseEntity<?> getOne(String todo);
   ResponseEntity<?> createOne(ToDoEntity toDoEntity, Locale locale);
   ResponseEntity<?> putOne(ToDoEntity toDoEntity, Locale locale);
   ResponseEntity<?> deleteOne(String todo);
}
