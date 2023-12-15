package com.java.unitaire.services;
import com.java.unitaire.ToDoList;
import com.java.unitaire.repository.*;
import com.java.unitaire.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemsServices {

    private final ItemsRepository itemsRepository;

    @Autowired
    public ItemsServices(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }

    public Items createItems(Items items) {
        return itemsRepository.save(items);
    }
    public Items getItemsById(Long id) {
        return itemsRepository.findById(id).orElse(null);
    }
}

