package com.ashwanicoding.hotel_management.service;

import com.ashwanicoding.hotel_management.entity.Bill;
import com.ashwanicoding.hotel_management.entity.BillItem;
import com.ashwanicoding.hotel_management.entity.Item;
import com.ashwanicoding.hotel_management.repository.BillRepository;
import com.ashwanicoding.hotel_management.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BillService {

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private ItemRepository itemRepository;

    public List<Bill> getAllBills(){
        return billRepository.findAll();
    }

    public Optional<Bill> getBillById(Long id){
        return billRepository.findById(id);
    }

    public Bill createBill(Bill bill){

        double totalAmount = 0.0;

        for (BillItem billItem : bill.getBillItems()) {
            // Fetch latest item price from DB
            Item item = itemRepository.findById(billItem.getItem().getId())
                    .orElseThrow(() -> new RuntimeException("Item not found with ID: " + billItem.getItem().getId()));

            billItem.setItem(item);
            billItem.setBill(bill); // set reference for JPA
            totalAmount += item.getPrice() * billItem.getQuantity();
        }

        bill.setTotalAmount(totalAmount);
        bill.setDate(LocalDate.now());
        return billRepository.save(bill);

    }

    public Bill updateBill(Long id, Bill updatedBill) {
        Bill existingBill = billRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bill not found with ID: " + id));

        existingBill.setCustomerName(updatedBill.getCustomerName());

        // Remove old bill items
        existingBill.getBillItems().clear();

        double totalAmount = 0.0;

        for (BillItem billItem : updatedBill.getBillItems()) {
            Item item = itemRepository.findById(billItem.getItem().getId())
                    .orElseThrow(() -> new RuntimeException("Item not found with ID: " + billItem.getItem().getId()));
            billItem.setItem(item);
            billItem.setBill(existingBill);
            existingBill.getBillItems().add(billItem);

            totalAmount += item.getPrice() * billItem.getQuantity();
        }

        existingBill.setTotalAmount(totalAmount);
        return billRepository.save(existingBill);
    }

    public void deleteBill(Long id) {
        billRepository.deleteById(id);
    }

}
