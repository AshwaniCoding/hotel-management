package com.ashwanicoding.hotel_management.controller;

import com.ashwanicoding.hotel_management.entity.Item;
import com.ashwanicoding.hotel_management.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/items")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping
    public String listItems(Model model) {
        model.addAttribute("items", itemService.getAllItems());
        return "jsp/items";
    }

    @GetMapping("/new")
    public String showCreateItemForm(Model model) {
        model.addAttribute("item", new Item());
        return "jsp/createItem";
    }

    @PostMapping("/save")
    public String saveItem(@ModelAttribute Item item) {
        itemService.createItem(item);
        return "redirect:/items";
    }

    @GetMapping("/{id}/edit")
    public String showEditItemForm(@PathVariable Long id, Model model) {
        model.addAttribute("item", itemService.getItemById(id).orElseThrow(() -> new RuntimeException("Item not found")));
        return "jsp/editItem";
    }

    @PostMapping("/{id}/update")
    public String updateItem(@PathVariable Long id, @ModelAttribute Item item) {
        itemService.updateItem(id, item);
        return "redirect:/items";
    }


}
