package com.ashwanicoding.hotel_management.repository;

import com.ashwanicoding.hotel_management.entity.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class ItemRepositoryTest {
    @Autowired
    private ItemRepository itemRepository;

    @Test
    void saveAndFindItem() {
        Item item = new Item();
        item.setName("Test Item");
        item.setPrice(100.0);
        Item saved = itemRepository.save(item);
        assertThat(itemRepository.findById(saved.getId())).isPresent();
    }
}
