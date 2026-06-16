import React, { useState, useEffect } from "react";
import axios from "axios";

function SearchTransaction() {

  const [transactions, setTransactions] = useState([]);
  const [search, setSearch] = useState("");
  const [filtered, setFiltered] = useState([]);

  useEffect(() => {
    fetchTransactions();
  }, []);

  const fetchTransactions = async () => {
    try {
      const response = await axios.get("http://localhost:9091/csv/all");
      setTransactions(response.data);
    } catch (error) {
      console.log(error);
    }
  };

  const handleSearch = () => {

    const result = transactions.filter((item) =>
      item.referenceId &&
      item.referenceId.toLowerCase().includes(search.toLowerCase())
    );

    setFiltered(result);
  };

  return (
    <div className="card p-4 mt-4">

      <h2>Search Transaction</h2>

      <input
        type="text"
        className="form-control mt-3"
        placeholder="Enter Reference ID"
        value={search}
        onChange={(e) => setSearch(e.target.value)}
      />

      <button
        className="btn btn-dark mt-3 w-100"
        onClick={handleSearch}
      >
        Search
      </button>

      <table className="table table-striped mt-4">

        <thead className="table-dark">
          <tr>
            <th>ID</th>
            <th>Reference ID</th>
            <th>Amount</th>
            <th>Status</th>
          </tr>
        </thead>

        <tbody>

          {filtered.length > 0 ? (
            filtered.map((item) => (
              <tr key={item.id}>
                <td>{item.id}</td>
                <td>{item.referenceId}</td>
                <td>{item.amount}</td>
                <td>{item.status}</td>
              </tr>
            ))
          ) : (
            <tr>
              <td colSpan="4" className="text-center">
                No Transactions Found
              </td>
            </tr>
          )}

        </tbody>

      </table>

    </div>
  );
}

export default SearchTransaction;