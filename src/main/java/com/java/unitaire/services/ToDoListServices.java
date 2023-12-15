package com.java.unitaire.services;
import com.java.unitaire.repository.ToDoListRepository;
import com.java.unitaire.ToDoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoListServices {

    private final ToDoListRepository toDoListRepository;

    @Autowired
    public ToDoListServices(ToDoListRepository toDoListRepository) {
        this.toDoListRepository = toDoListRepository;
    }

    public ToDoList createToDoList(ToDoList toDoList) {
        return toDoListRepository.save(toDoList);
    }

}

