import React, { useState } from "react";
import axios from "axios";

import TransactionTable from "../components/TransactionTable";
import ReconciliationSummary from "../components/ReconciliationSummary";
import SearchTransaction from "../components/SearchTransaction";

function Dashboard() {

    const [file, setFile] = useState(null);
    const [message, setMessage] = useState("");

    const [transactions, setTransactions] = useState([]);

    const handleUpload = async () => {

        if (!file) {
            setMessage("Please select CSV file");
            return;
        }

        const formData = new FormData();

        formData.append("file", file);

        try {

            const response = await axios.post(
                "http://localhost:9091/csv/upload",
                formData
            );

            setTransactions(response.data);

            setMessage("CSV Uploaded Successfully");

        } catch (error) {

            console.log(error);

            setMessage("Upload Failed");
        }
    };

    return (

        <div className="container mt-4">

            <div className="card p-4">

                <h1>Dashboard</h1>

                <div className="mb-3">
                    <label className="form-label">
                        Upload Transaction CSV File
                    </label>

                    <input
                        type="file"
                        className="form-control"
                        onChange={(e) => setFile(e.target.files[0])}
                    />
                </div>

                <button
                    className="btn btn-primary"
                    onClick={handleUpload}
                >
                    Upload CSV
                </button>

                {message && (
                    <div className="alert alert-info mt-3">
                        {message}
                    </div>
                )}

            </div>

            <TransactionTable />

            <ReconciliationSummary />

            <SearchTransaction transactions={transactions} />

        </div>
    );
}

export default Dashboard;