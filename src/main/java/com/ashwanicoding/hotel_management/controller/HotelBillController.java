package com.ashwanicoding.hotel_management.controller;

import com.ashwanicoding.hotel_management.entity.Bill;
import com.ashwanicoding.hotel_management.service.BillService;
import com.ashwanicoding.hotel_management.service.ItemService;
import com.ashwanicoding.hotel_management.utils.Logging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/bills")
public class HotelBillController {

    @Autowired
    private BillService billService;

    @Autowired
    private ItemService itemService;



    /**
     * List all bills on /bills
     */
    @GetMapping
    public String listBills(Model model) {
        List<Bill> bills = billService.getAllBills();
        model.addAttribute("bills", bills);
        Logging.getLogger().info("Getting all bills");
        return "bills"; // JSP page to display all bills
    }

    /**
     * Show form to create a new bill
     */
    @GetMapping("/new")
    public String showCreateBillForm(Model model) {
        Bill bill = new Bill();
        bill.setDate(LocalDate.now()); // Default today's date
        model.addAttribute("bill", bill);
        model.addAttribute("items", itemService.getAllItems());
        Logging.getLogger().info("New bill created");
        return "createBill"; // JSP form page
    }

    /**
     * Save a new bill
     */
    @PostMapping("/save")
    public String saveBill(@ModelAttribute("bill") Bill bill) {
        // Date set automatically if needed
        billService.createBill(bill);
        Logging.getLogger().info("Saved new bill");
        return "redirect:/bills";
    }

    /**
     * View a specific bill
     */
    @GetMapping("/{id}")
    public String viewBill(@PathVariable Long id, Model model) {
        Optional<Bill> billOpt = billService.getBillById(id);
        if (billOpt.isPresent()) {
            model.addAttribute("bill", billOpt.get());
            return "viewBill"; // JSP page for bill details
        } else {
            return "redirect:/bills";
        }
    }

    /**
     * Show form to edit a bill
     */
    @GetMapping("/{id}/edit")
    public String showEditBillForm(@PathVariable Long id, Model model) {
        Optional<Bill> billOpt = billService.getBillById(id);
        if (billOpt.isPresent()) {
            model.addAttribute("bill", billOpt.get());
            model.addAttribute("items", itemService.getAllItems());
            return "editBill"; // JSP form page
        } else {
            return "redirect:/bills";
        }
    }

    /**
     * Update a bill
     */
    @PostMapping("/{id}/update")
    public String updateBill(@PathVariable Long id, @ModelAttribute("bill") Bill bill) {
        billService.updateBill(id, bill);
        return "redirect:/bills";
    }

    /**
     * Delete a bill
     */
    @GetMapping("/{id}/delete")
    public String deleteBill(@PathVariable Long id) {
        billService.deleteBill(id);
        return "redirect:/bills";
    }

}
