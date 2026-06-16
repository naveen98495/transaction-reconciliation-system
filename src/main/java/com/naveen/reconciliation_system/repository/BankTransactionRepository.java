package com.naveen.reconciliation_system.repository;

import com.naveen.reconciliation_system.entity.BankTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankTransactionRepository extends JpaRepository<BankTransaction, Long> {

}