package com.naveen.reconciliation_system.repository;

import com.naveen.reconciliation_system.entity.TransactionRecord;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository
        extends JpaRepository<TransactionRecord, Long> {

    List<TransactionRecord> findByStatus(String status);
}