import React, { useEffect, useState } from "react";

import Apis, { deleteUser, endpoints } from "../../configs/Apis";
import { Button, Card, Col, Container, Form, Row } from "react-bootstrap";
import DataTable, { createTheme } from "react-data-table-component";
import { Link } from "react-router-dom";

const UserAdmin = () => {
  const [users, setUsers] = useState([]);
  const [records, setRecords] = useState([]);

  const deleteUserButton = (userId) => {
    deleteUser(userId);
    setUsers([]);
  };

  useEffect(() => {
    const loadDpm = async () => {
      let e = endpoints["users"];
      let res = await Apis.get(e);

      setUsers(res.data);
      setRecords(res.data);
    };
    loadDpm();
  }, [users]);

  const handleFilter = (evt) => {
    const newData = users.filter((row) => {
      return (row.firstName + " " + row.lastName)
        .toLowerCase()
        .includes(evt.target.value.toLowerCase());
    });
    setRecords(newData);
  };

  const columns = [
    {
      name: "Id",
      selector: (r) => r.id,
      sortable: true,
    },
    {
      name: "Full Name",
      selector: (r) => r.lastName + " " + r.firstName,
    },
    {
      name: "Username",
      selector: (r) => r.username,
      sortable: true,
    },
    {
      name: "Email",
      selector: (r) => r.email,
    },
    {
      name: "Role",
      selector: (r) => r.userRole.name,
    },
    {
      name: "Active",
      selector: (r) => String(r.active),
      sortable: true,
    },
    {
      name: "",
      button: true,
      cell: (r) => (
        <Link to={`/useradmin/${r.id}`}>
          <Button variant="primary">Change</Button>
        </Link>
      ),
    },
    {
      name: "",
      button: true,
      cell: (r) => (
        <Link onClick={() => deleteUserButton(r.id)}>
          <Button variant="success">Delete</Button>
        </Link>
      ),
    },
  ];

  createTheme(
    "solarized",
    {
      text: {
        primary: "#fff",
        secondary: "#2aa198",
      },
      background: {
        default: "#002b36",
      },
      context: {
        background: "#cb4b16",
        text: "#FFFFFF",
      },
      divider: {
        default: "#2aa198",
      },
      action: {
        button: "rgba(0,0,0,.54)",
        hover: "rgba(0,0,0,.08)",
        disabled: "rgba(0,0,0,.12)",
      },
    },
    "dark"
  );

  return (
    <>
      <main className="main-container">
        <div className="d-flex">
          <form class="d-flex" action="#">
            <div class="input-group my-3 my-lg-0">
              <input
                type="text"
                class="form-control"
                name="kw"
                placeholder="Search..."
                aria-label="Search"
                onChange={handleFilter}
              />
            </div>
          </form>{" "}
          <div className="ms-3">
            <Link to="/edituser">
              <Button>Add User</Button>
            </Link>
          </div>
        </div>
        <div className="mt-2">
          <DataTable
            columns={columns}
            data={records}
            fixedHeader
            pagination
            theme="solarized"
          ></DataTable>
        </div>
      </main>
    </>
  );
};

export default UserAdmin;
