package com.naveen.reconciliation_system.service;

import com.naveen.reconciliation_system.entity.TransactionRecord;
import com.naveen.reconciliation_system.repository.TransactionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    // SAVE TRANSACTION
    public TransactionRecord saveTransaction(
            TransactionRecord transaction) {

        return transactionRepository.save(transaction);
    }

    // GET ALL TRANSACTIONS
    public List<TransactionRecord> getAllTransactions() {

        return transactionRepository.findAll();
    }

    // GET TRANSACTION BY ID
    public TransactionRecord getTransactionById(Long id) {

        return transactionRepository.findById(id)
                .orElse(null);
    }

    // UPDATE TRANSACTION
    public TransactionRecord updateTransaction(
            Long id,
            TransactionRecord updatedTransaction) {

        TransactionRecord existingTransaction =
                transactionRepository.findById(id)
                        .orElse(null);

        if (existingTransaction != null) {

            existingTransaction.setReferenceId(
                    updatedTransaction.getReferenceId());

            existingTransaction.setAmount(
                    updatedTransaction.getAmount());

            existingTransaction.setStatus(
                    updatedTransaction.getStatus());

            return transactionRepository.save(
                    existingTransaction);
        }

        return null;
    }

    // DELETE TRANSACTION
    public String deleteTransaction(Long id) {

        transactionRepository.deleteById(id);

        return "Transaction Deleted Successfully";
    }

    // SEARCH BY STATUS
    public List<TransactionRecord> getTransactionsByStatus(
            String status) {

        return transactionRepository.findByStatus(status);
    }

    // PAGINATION + SORTING
    public Page<TransactionRecord> getTransactionsPaginated(
            int page,
            int size,
            String sortBy) {

        Pageable pageable = PageRequest.of(
                page,
                size,
                Sort.by(sortBy)
        );

        return transactionRepository.findAll(pageable);
    }
}