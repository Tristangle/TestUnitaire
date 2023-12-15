package com.java.unitaire.repository;

import com.java.unitaire.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoListRepository extends JpaRepository<ToDoList, Long> {


}
