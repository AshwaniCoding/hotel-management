package com.ashwanicoding.hotel_management.repository;

import com.ashwanicoding.hotel_management.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
