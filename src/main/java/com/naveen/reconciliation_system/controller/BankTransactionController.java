package com.naveen.reconciliation_system.controller;

import com.naveen.reconciliation_system.entity.BankTransaction;
import com.naveen.reconciliation_system.service.BankTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank-transactions")
public class BankTransactionController {

    @Autowired
    private BankTransactionService bankTransactionService;

    @GetMapping
    public List<BankTransaction> getAllBankTransactions() {
        return bankTransactionService.getAllBankTransactions();
    }
}