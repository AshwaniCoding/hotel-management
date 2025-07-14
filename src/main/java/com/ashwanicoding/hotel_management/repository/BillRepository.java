package com.ashwanicoding.hotel_management.repository;

import com.ashwanicoding.hotel_management.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill, Long> {
}
