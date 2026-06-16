package com.naveen.reconciliation_system.controller;

import com.naveen.reconciliation_system.entity.TransactionRecord;
import com.naveen.reconciliation_system.repository.TransactionRepository;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

@RestController
@RequestMapping("/csv")
@CrossOrigin(origins = "*")

public class CsvController {

    @Autowired
    private TransactionRepository transactionRepository;

    @PostMapping("/upload")
    public String uploadCsv(@RequestParam("file") MultipartFile file) {

        try {

            Reader reader =
                    new InputStreamReader(file.getInputStream());

            CSVParser csvParser =
                    new CSVParser(
                            reader,
                            CSVFormat.DEFAULT
                                    .withFirstRecordAsHeader()
                                    .withIgnoreHeaderCase()
                                    .withTrim()
                    );

            for (CSVRecord csvRecord : csvParser) {

                TransactionRecord transaction =
                        new TransactionRecord();

                transaction.setAmount(
                        Double.parseDouble(
                                csvRecord.get("amount")
                        )
                );

                transaction.setStatus(
                        csvRecord.get("status")
                );

                transaction.setReferenceId(
                        csvRecord.get("reference_id")
                );

                transactionRepository.save(transaction);
            }

            return "CSV Uploaded Successfully";

        } catch (Exception e) {

            return "Error : " + e.getMessage();

        }
    }

    @GetMapping("/all")
    public List<TransactionRecord> getAllTransactions() {

        return transactionRepository.findAll();

    }
}