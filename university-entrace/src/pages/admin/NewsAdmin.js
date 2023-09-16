import React, { useEffect, useState } from "react";
import Apis, { endpoints } from "../../configs/Apis";
import { Button, Image } from "react-bootstrap";
import DataTable, { createTheme } from "react-data-table-component";
import moment from "moment";
import { Link } from "react-router-dom";

const NewsAdmin = () => {
  const [news, setNews] = useState([]);
  const [records, setRecords] = useState([]);

  useEffect(() => {
    const loadDpm = async () => {
      let e = endpoints["news"];
      let res = await Apis.get(e);

      setNews(res.data);
      setRecords(res.data);
    };
    loadDpm();
  }, []);
  const handleFilter = (evt) => {
    const newData = news.filter((row) => {
      return row.title.toLowerCase().includes(evt.target.value.toLowerCase());
    });
    setRecords(newData);
  };
  const CustomTitle = ({ row }) => (
    <div>
      {}
      <div>{row.title}</div>
      <div>
        <div
          data-tag="allowRowEvents"
          style={{
            color: "grey",
            overflow: "hidden",
            whiteSpace: "wrap",
            textOverflow: "ellipses",
          }}
        >
          {}
          {row.plot}
        </div>
      </div>
    </div>
  );
  const columns = [
    {
      name: "Id",
      selector: (r) => r.id,
      sortable: true,
      maxWidth: "60px",
      minWidth: "60px",
    },
    {
      name: "Title",
      selector: (r) => r.title,
      sortable: true,
      maxWidth: "250px",
    },
    {
      name: "Content",
      selector: (r) => r.content,
      sortable: true,
      wrap: true,
      format: (r) => `${r.content.slice(0, 100)}...`,
    },
    {
      name: "Created",
      selector: (r) => moment(new Date(r.createdDate)).format("DD/MM/YYYY"),
      sortable: true,
      maxWidth: "100px",
    },
    {
      name: "Deparment",
      selector: (r) => r.recruitmentId.deparmentId.name,
    },
    {
      name: "",
      button: true,
      cell: (r) => (
        <Link to={`/newsadmin/${r.id}`}>
          <Button setTest variant="info">
            <i class="fa-solid fa-gear"></i>
          </Button>
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
        </form>
        <div className="ms-3">
          <Link to="/editnews">
            <Button>Add News</Button>
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
  );
};

export default NewsAdmin;
