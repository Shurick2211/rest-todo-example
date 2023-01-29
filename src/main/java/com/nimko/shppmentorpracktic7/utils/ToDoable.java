package com.nimko.shppmentorpracktic7.utils;

import com.nimko.shppmentorpracktic7.dto.ToDoDto;
import com.nimko.shppmentorpracktic7.models.User;
import org.springframework.http.ResponseEntity;

import java.util.Locale;

public interface ToDoable {
   ResponseEntity<?> getAll(User user);
   ResponseEntity<?> getOne(Long id, User user);
   ResponseEntity<?> createOne(ToDoDto dto, User user, Locale locale);
   ResponseEntity<?> putOne(ToDoDto dto, User user, Locale locale);
   ResponseEntity<?> deleteOne(Long id, User user, Locale locale);
}
