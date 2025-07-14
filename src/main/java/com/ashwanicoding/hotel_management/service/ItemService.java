package com.ashwanicoding.hotel_management.service;

import com.ashwanicoding.hotel_management.entity.Item;
import com.ashwanicoding.hotel_management.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getAllItems(){
        return itemRepository.findAll();
    }

    public Optional<Item> getItemById(Long id){
        return itemRepository.findById(id);
    }

    public Item addItem(Item item){
        return itemRepository.save(item);
    }

    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    public Item updateItem(Long id, Item updatedItem) {
        Item existingItem = itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found"));

        existingItem.setName(updatedItem.getName());
        existingItem.setPrice(updatedItem.getPrice());

        return itemRepository.save(existingItem);
    }

}
