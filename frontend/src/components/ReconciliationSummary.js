import React, { useEffect, useState } from "react";
import axios from "axios";

function ReconciliationSummary() {

    const [transactions, setTransactions] = useState([]);

    useEffect(() => {

        fetchTransactions();

    }, []);

    const fetchTransactions = async () => {

        try {

            const response = await axios.get(
                "http://localhost:9091/csv/all"
            );

            setTransactions(response.data);

        } catch (error) {

            console.log(error);

        }
    };

    const totalTransactions = transactions.length;

    const successCount = transactions.filter(
        (txn) => txn.status === "SUCCESS"
    ).length;

    const failedCount = transactions.filter(
        (txn) => txn.status === "FAILED"
    ).length;

    const pendingCount = transactions.filter(
        (txn) => txn.status === "PENDING"
    ).length;

    const invalidAmountCount = transactions.filter(
        (txn) => txn.amount <= 0
    ).length;

    const duplicateIds = [];

    transactions.forEach((txn) => {

        const count = transactions.filter(
            (t) => t.referenceId === txn.referenceId
        ).length;

        if (count > 1 && txn.referenceId) {

            duplicateIds.push(txn.referenceId);
        }
    });

    const duplicateCount = [...new Set(duplicateIds)].length;

    return (

        <div className="container mt-4">

            <div className="card shadow p-4">

                <h2 className="mb-4">
                    Reconciliation Analysis
                </h2>

                <div className="row">

                    <div className="col-md-4 mb-3">
                        <div className="alert alert-primary">
                            Total Transactions :
                            <strong> {totalTransactions}</strong>
                        </div>
                    </div>

                    <div className="col-md-4 mb-3">
                        <div className="alert alert-success">
                            Success :
                            <strong> {successCount}</strong>
                        </div>
                    </div>

                    <div className="col-md-4 mb-3">
                        <div className="alert alert-danger">
                            Failed :
                            <strong> {failedCount}</strong>
                        </div>
                    </div>

                    <div className="col-md-4 mb-3">
                        <div className="alert alert-warning">
                            Pending :
                            <strong> {pendingCount}</strong>
                        </div>
                    </div>

                    <div className="col-md-4 mb-3">
                        <div className="alert alert-dark">
                            Duplicate IDs :
                            <strong> {duplicateCount}</strong>
                        </div>
                    </div>

                    <div className="col-md-4 mb-3">
                        <div className="alert alert-secondary">
                            Invalid Amounts :
                            <strong> {invalidAmountCount}</strong>
                        </div>
                    </div>

                </div>

                <div className="mt-4">

                    <h4>
                        Suggestions
                    </h4>

                    <ul>

                        {failedCount > 0 && (
                            <li>
                                Check failed transactions with payment gateway
                            </li>
                        )}

                        {pendingCount > 0 && (
                            <li>
                                Reprocess pending transactions
                            </li>
                        )}

                        {duplicateCount > 0 && (
                            <li>
                                Verify duplicate transaction reference IDs
                            </li>
                        )}

                        {invalidAmountCount > 0 && (
                            <li>
                                Remove invalid negative amount transactions
                            </li>
                        )}

                    </ul>

                </div>

            </div>

        </div>
    );
}

export default ReconciliationSummary;