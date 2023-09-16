import React, { useEffect, useState } from "react";
import Apis, { endpoints } from "../../configs/Apis";
import { Button, Image } from "react-bootstrap";
import DataTable, { createTheme } from "react-data-table-component";
import moment from "moment";
import { Link } from "react-router-dom";

const BannerAdmin = () => {
  const [banner, setBanner] = useState([]);
  const [records, setRecords] = useState([]);

  useEffect(() => {
    const loadDpm = async () => {
      let e = endpoints["banners-full"];
      let res = await Apis.get(e);

      setBanner(res.data);
      setRecords(res.data);
    };
    loadDpm();
  }, []);
  const handleFilter = (evt) => {
    const newData = banner.filter((row) => {
      return row.title.toLowerCase().includes(evt.target.value.toLowerCase());
    });
    setRecords(newData);
  };
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
      maxWidth: "100px",
    },
    {
      name: "Image",
      selector: (r) => (
        <Image className="mt-3 mb-3" fluid rounded src={r.link}></Image>
      ),
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
      name: "Status",
      selector: (r) => String(r.status),
      sortable: true,
    },
    {
      name: "",
      button: true,
      cell: (r) => (
        <Link to={`/banners/${r.id}`}>
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
          <Link to="/editbanner">
            <Button>Add Banner</Button>
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

export default BannerAdmin;
