package com.java.unitaire.controlleur;
import com.java.unitaire.Items;
import com.java.unitaire.ToDoList;
import com.java.unitaire.services.ItemsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users/:id/todos")
public class ItemsControlleur {

    private final ItemsServices itemsService;

    @Autowired
    public ItemsControlleur(ItemsServices itemsService) {
        this.itemsService = itemsService;
    }
    @GetMapping("/{id}")
    public Items getItems(@PathVariable Long id) {
            return itemsService.getItemsById(id);
    }

    @PostMapping
    public Items createItems(@RequestBody Items items) {
        return itemsService.createItems(items);
    }
}