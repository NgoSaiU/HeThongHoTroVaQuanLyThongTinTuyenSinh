import React, { useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom";
import Apis, { endpoints, updateBanner } from "../../configs/Apis";

const EditBanner = () => {
  const { bannerId } = useParams();
  const [banner, setBanner] = useState(null);
  const [checked, setChecked] = useState(false);
  const [title, setTitle] = useState();

  const enable = (evt) => {
    setChecked(!checked);
  };

  const handleUpdate = () => {
    setBanner((banner.title = title), (banner.status = checked));
    updateBanner(banner.recruitmentId.id, banner.id, banner);
  };

  useEffect(() => {
    const loadDpm = async () => {
      if (bannerId !== undefined) {
        let e = endpoints["banners-full"];
        e = `${e}?bannerid=${bannerId}`;
        console.log(e);
        let res = await Apis.get(e);
        setBanner(res.data[0]);
        setTitle(res.data[0].title);
        setChecked(Boolean(res.data[0].status));
      }
    };
    loadDpm();
  }, [bannerId]);
  return (
    <>
      <main className="main-container sm">
        <form>
          <div class="mb-3">
            <label for="title" class="form-label">
              Title
            </label>
            <input
              type="text"
              class="form-control"
              id="title"
              defaultValue={banner ? banner.title : ""}
              onChange={(e) => setTitle(e.target.value)}
            />
          </div>
          <div class="form-check form-switch">
            <input
              class="form-check-input"
              type="checkbox"
              role="switch"
              id="status"
              name="status"
              onClick={enable}
              checked={checked}
            />
            <label class="form-check-label" for="status">
              Status
            </label>
          </div>
          <div>
            <Link to="/banners" onClick={handleUpdate}>
              <button type="submit" class="btn btn-primary">
                Submit
              </button>
            </Link>
          </div>
        </form>
      </main>
    </>
  );
};

export default EditBanner;
