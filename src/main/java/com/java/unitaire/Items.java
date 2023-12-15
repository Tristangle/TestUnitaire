package com.java.unitaire;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.time.LocalDate;
@Setter
@Entity
@Table(name = "items")
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private long id;
    @Getter
    private String name;
    private String content;
    @Getter
    private LocalDateTime dateCreation;
    @ManyToOne
    @JoinColumn(name = "TodoList")
    private ToDoList todolist;
    public Items(String name, String content){
        this.name = name;
        this.content = content;
        this.dateCreation = LocalDateTime.now();
    }

    public Items() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isValidItem(){
        if(name.isEmpty()){
            return false;
        }
        if(content.length()> 1000){
            return false;
        }
        return true;
    }
}
