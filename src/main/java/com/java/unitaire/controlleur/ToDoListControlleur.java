package com.java.unitaire.controlleur;
import com.java.unitaire.services.ToDoListServices;
import com.java.unitaire.ToDoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users/:id/todos")
public class ToDoListControlleur {

    private final ToDoListServices toDoListService;

    @Autowired
    public ToDoListControlleur(ToDoListServices toDoListService) {
        this.toDoListService = toDoListService;
    }

    @PostMapping
    public ToDoList createToDoList(@RequestBody ToDoList toDoList) {
        return toDoListService.createToDoList(toDoList);
    }

}