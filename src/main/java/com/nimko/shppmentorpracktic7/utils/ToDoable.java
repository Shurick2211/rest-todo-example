package com.nimko.shppmentorpracktic7.utils;

import com.nimko.shppmentorpracktic7.models.ToDoEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface ToDoable {

    public ResponseEntity<?> getAll();


    public ResponseEntity<?> getOne(String todo);



    public ResponseEntity<?> createOne(ToDoEntity toDoEntity);

    public ResponseEntity<?> putOne(ToDoEntity toDoEntity);

    public ResponseEntity<?> deleteOne(String todo);
}
