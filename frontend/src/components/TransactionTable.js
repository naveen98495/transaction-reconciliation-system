import React, { useEffect, useState } from "react";
import axios from "axios";

function TransactionTable() {

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

    return (

        <div className="container mt-4">

            <div className="card shadow p-3">

                <h3 className="mb-3">
                    Transaction Records
                </h3>

                <table className="table table-bordered table-striped">

                    <thead className="table-dark">

                        <tr>
                            <th>ID</th>
                            <th>Reference ID</th>
                            <th>Amount</th>
                            <th>Status</th>
                        </tr>

                    </thead>

                    <tbody>

                        {transactions.map((txn) => (

                            <tr key={txn.id}>

                                <td>{txn.id}</td>

                                <td>{txn.referenceId}</td>

                                <td>{txn.amount}</td>

                                <td>

                                    <span
                                        className={
                                            txn.status === "SUCCESS"
                                                ? "badge bg-success"
                                                : txn.status === "FAILED"
                                                ? "badge bg-danger"
                                                : "badge bg-warning text-dark"
                                        }
                                    >
                                        {txn.status}
                                    </span>

                                </td>

                            </tr>

                        ))}

                    </tbody>

                </table>

            </div>

        </div>
    );
}

export default TransactionTable;