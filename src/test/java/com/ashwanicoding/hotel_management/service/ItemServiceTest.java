package com.ashwanicoding.hotel_management.service;

import com.ashwanicoding.hotel_management.entity.Item;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ItemServiceTest {
    @MockBean
    private ItemService itemService;

    @Test
    void getItemByIdReturnsEmpty() {
        Mockito.when(itemService.getItemById(1L)).thenReturn(Optional.empty());
        assertThat(itemService.getItemById(1L)).isEmpty();
    }
}
