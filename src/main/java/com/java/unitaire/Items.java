package com.java.unitaire;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.time.LocalDate;
@Setter
public class Items {
    @Getter
    private String name;

    private String content;
    @Getter
    private LocalDateTime dateCreation;

    public Items(String name, String content){
        this.name = name;
        this.content = content;
        this.dateCreation = LocalDateTime.now();
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
