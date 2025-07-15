package com.ashwanicoding.hotel_management.repository;

import com.ashwanicoding.hotel_management.entity.Bill;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class BillRepositoryTest {
    @Autowired
    private BillRepository billRepository;

    @Test
    void saveAndFindBill() {
        Bill bill = new Bill();
        bill.setCustomerName("Test Customer");
        bill.setDate(LocalDate.now());
        bill.setTotalAmount(200.0);
        Bill saved = billRepository.save(bill);
        assertThat(billRepository.findById(saved.getId())).isPresent();
    }
}
