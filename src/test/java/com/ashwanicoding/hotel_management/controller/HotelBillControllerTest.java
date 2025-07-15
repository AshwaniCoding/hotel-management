package com.ashwanicoding.hotel_management.controller;

import com.ashwanicoding.hotel_management.entity.Bill;
import com.ashwanicoding.hotel_management.service.BillService;
import com.ashwanicoding.hotel_management.service.ItemService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@WebMvcTest(HotelBillController.class)
@AutoConfigureMockMvc(addFilters = false)
class HotelBillControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BillService billService;
    @MockBean
    private ItemService itemService;

    @Test
    void listBillsRendersView() throws Exception {
        Mockito.when(billService.getAllBills()).thenReturn(Collections.emptyList());
        mockMvc.perform(get("/bills"))
                .andExpect(status().isOk())
                .andExpect(view().name("jsp/bills"))
                .andExpect(model().attributeExists("bills"));
    }
}
