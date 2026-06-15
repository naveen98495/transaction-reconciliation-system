package com.naveen.reconciliation_system.service;

import com.naveen.reconciliation_system.dto.ReconciliationResult;
import com.naveen.reconciliation_system.dto.ReconciliationSummary;
import com.naveen.reconciliation_system.entity.BankTransaction;
import com.naveen.reconciliation_system.entity.TransactionRecord;
import com.naveen.reconciliation_system.repository.BankTransactionRepository;
import com.naveen.reconciliation_system.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReconciliationService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private BankTransactionRepository bankTransactionRepository;

    public List<ReconciliationResult> reconcileTransactions() {

        List<TransactionRecord> transactions =
                transactionRepository.findAll();

        List<BankTransaction> bankTransactions =
                bankTransactionRepository.findAll();

        List<ReconciliationResult> results =
                new ArrayList<>();

        for (TransactionRecord t : transactions) {

            boolean found = false;

            for (BankTransaction b : bankTransactions) {

                if (t.getReferenceId().equals(b.getReferenceId())
                        && t.getAmount().equals(b.getAmount())) {

                    ReconciliationResult result =
                            new ReconciliationResult();

                    result.setTransactionId(t.getId());

                    result.setStatus("MATCHED");

                    results.add(result);

                    found = true;

                    break;
                }
            }

            if (!found) {

                ReconciliationResult result =
                        new ReconciliationResult();

                result.setTransactionId(t.getId());

                result.setStatus("NOT MATCHED");

                results.add(result);
            }
        }

        return results;
    }

    public ReconciliationSummary getSummary() {

        List<ReconciliationResult> results =
                reconcileTransactions();

        long total = results.size();

        long matched = results.stream()
                .filter(r -> r.getStatus().equals("MATCHED"))
                .count();

        long unmatched = total - matched;

        double successPercentage = 0;

        if (total > 0) {

            successPercentage =
                    ((double) matched / total) * 100;
        }

        return new ReconciliationSummary(
                total,
                matched,
                unmatched,
                successPercentage
        );
    }
}