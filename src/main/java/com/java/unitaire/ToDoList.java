package com.java.unitaire;

import com.java.unitaire.EmailSenderService;
import com.java.unitaire.Items;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Entity
@Setter
@Table(name = "todolist")
public class ToDoList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private long id;

    @OneToMany(mappedBy = "ToDoList", cascade = CascadeType.ALL)
    private ArrayList<Items> tableauItems;
    @OneToOne(mappedBy = "toDoList")
    @Getter
    private User user;
    //private EmailSenderService emailSenderService;

    public ToDoList(ArrayList<Items> tableauItems, EmailSenderService emailSenderService){
        this.tableauItems = tableauItems;
        //this.emailSenderService = emailSenderService;
    }

    public ToDoList() {

    }

    public boolean checkItemName(Items Item){
            for (Items tableauItem : tableauItems) {
                if (Item.getName().equals(tableauItem.getName())) {
                    return false;
                }
            }
        return true;
    }
    public boolean checkNombreItems(){
        return tableauItems.size() <= 9;
    }
    public boolean isValidItemDate(Items Item){
        if(tableauItems.isEmpty()){
            return true;
        }
        LocalDateTime lastDateItem =  tableauItems.get(tableauItems.size()-1).getDateCreation();

        if(Item.getDateCreation().isAfter(lastDateItem.plusMinutes(30))){
            return true;
        }
        return false;
    }
    public boolean isSaved(){
        throw new IllegalArgumentException();
    }

    void addItems(Items Item) throws Exception {
        if(!Item.isValidItem()){
            throw new Exception("Item Incorrect");
        }
        if(!isValidItemDate(Item)){
            throw new Exception("Délais d'attente non atteint");
        }
        else{
            tableauItems.add(Item);
            if(tableauItems.size() == 8){
                //this.emailSenderService.sendEmail();
            }
        }

    }
    /*public boolean isValidToDoList(){
        if(!checkNombreItems()){
            return false;
        }
        return true;
    }*/

}
