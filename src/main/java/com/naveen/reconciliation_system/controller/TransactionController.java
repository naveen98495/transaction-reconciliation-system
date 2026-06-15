package com.naveen.reconciliation_system.controller;

import com.naveen.reconciliation_system.entity.TransactionRecord;
import com.naveen.reconciliation_system.repository.TransactionRepository;
import com.naveen.reconciliation_system.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private TransactionRepository transactionRepository;

    // CREATE
    @PostMapping
    public TransactionRecord createTransaction(
            @Valid @RequestBody TransactionRecord transaction) {

        return transactionService.saveTransaction(transaction);
    }

    // GET ALL
    @GetMapping
    public List<TransactionRecord> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public TransactionRecord getTransactionById(@PathVariable Long id) {
        return transactionService.getTransactionById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public TransactionRecord updateTransaction(
            @PathVariable Long id,
            @Valid @RequestBody TransactionRecord transaction) {

        return transactionService.updateTransaction(id, transaction);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteTransaction(@PathVariable Long id) {

        transactionService.deleteTransaction(id);

        return "Transaction deleted successfully";
    }

    // PAGINATION
    @GetMapping("/paged")
    public Page<TransactionRecord> getPagedTransactions(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        Pageable pageable = PageRequest.of(page, size);

        return transactionRepository.findAll(pageable);
    }
}