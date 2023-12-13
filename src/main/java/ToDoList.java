import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Setter
public class ToDoList {

    private ArrayList<Items> tableauItems;
    private EmailSenderService emailSenderService;

    public ToDoList(ArrayList<Items> tableauItems, EmailSenderService emailSenderService){
        this.tableauItems = tableauItems;
        this.emailSenderService = emailSenderService;
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
                this.emailSenderService.sendEmail();
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
