package com.naveen.reconciliation_system.dto;

public class ReconciliationSummary {

    private long totalTransactions;
    private long matchedTransactions;
    private long unmatchedTransactions;
    private double successPercentage;

    public ReconciliationSummary() {
    }

    public ReconciliationSummary(long totalTransactions,
                                 long matchedTransactions,
                                 long unmatchedTransactions,
                                 double successPercentage) {

        this.totalTransactions = totalTransactions;
        this.matchedTransactions = matchedTransactions;
        this.unmatchedTransactions = unmatchedTransactions;
        this.successPercentage = successPercentage;
    }

    public long getTotalTransactions() {
        return totalTransactions;
    }

    public void setTotalTransactions(long totalTransactions) {
        this.totalTransactions = totalTransactions;
    }

    public long getMatchedTransactions() {
        return matchedTransactions;
    }

    public void setMatchedTransactions(long matchedTransactions) {
        this.matchedTransactions = matchedTransactions;
    }

    public long getUnmatchedTransactions() {
        return unmatchedTransactions;
    }

    public void setUnmatchedTransactions(long unmatchedTransactions) {
        this.unmatchedTransactions = unmatchedTransactions;
    }

    public double getSuccessPercentage() {
        return successPercentage;
    }

    public void setSuccessPercentage(double successPercentage) {
        this.successPercentage = successPercentage;
    }
}