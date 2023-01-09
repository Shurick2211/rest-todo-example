package com.nimko.shppmentorpracktic7.utils;

import com.nimko.shppmentorpracktic7.dto.ToDoDto;
import com.nimko.shppmentorpracktic7.models.ToDoEntity;
import org.springframework.http.ResponseEntity;

import java.util.Locale;

public interface ToDoable {
   ResponseEntity<?> getAll();
   ResponseEntity<?> getOne(String todo);
   ResponseEntity<?> createOne(ToDoDto dto, Locale locale);
   ResponseEntity<?> putOne(ToDoDto dto, Locale locale);
   ResponseEntity<?> deleteOne(String todo, Locale locale);
}
