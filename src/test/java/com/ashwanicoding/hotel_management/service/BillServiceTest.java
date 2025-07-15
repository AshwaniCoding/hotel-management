package com.ashwanicoding.hotel_management.service;

import com.ashwanicoding.hotel_management.entity.Bill;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BillServiceTest {
    @MockBean
    private BillService billService;

    @Test
    void getBillByIdReturnsEmpty() {
        Mockito.when(billService.getBillById(1L)).thenReturn(Optional.empty());
        assertThat(billService.getBillById(1L)).isEmpty();
    }
}
