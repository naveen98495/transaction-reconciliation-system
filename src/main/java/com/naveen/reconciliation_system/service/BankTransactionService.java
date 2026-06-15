package com.naveen.reconciliation_system.service;

import com.naveen.reconciliation_system.entity.BankTransaction;
import com.naveen.reconciliation_system.repository.BankTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankTransactionService {

    @Autowired
    private BankTransactionRepository bankTransactionRepository;

    public List<BankTransaction> getAllBankTransactions() {
        return bankTransactionRepository.findAll();
    }
}