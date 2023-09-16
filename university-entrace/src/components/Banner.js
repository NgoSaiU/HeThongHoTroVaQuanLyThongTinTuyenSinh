import React, { useEffect, useState } from "react";
import Apis, { endpoints } from "../configs/Apis";
import MySpinner from "./MySpinner";
import {} from "../assets/styles/global.css";
import OwlCarousel from "react-owl-carousel";
import "owl.carousel/dist/assets/owl.carousel.css";
import "owl.carousel/dist/assets/owl.theme.default.css";

const Banner = () => {
  const [banners, setBanners] = useState([]);

  useEffect(() => {
    const loadBanners = async () => {
      let res = await Apis.get(endpoints["banners"]);
      setBanners(res.data);
    };
    loadBanners();
  }, []);
  if (banners.length === 0) return <MySpinner />;
  return (
    <>
      <div class="" id="banner">
        <OwlCarousel
          items={1}
          className="owl-theme"
          autoplay={true}
          margin={8}
          rewind={true}
          autoplaySpeed={2000}
          autoplayHoverPause
          nav={true}
        >
          {banners.map((b) => {
            return (
              <div key={b.id}>
                <img className="img slider-item" src={b.link} alt="banner" />
              </div>
            );
          })}
        </OwlCarousel>
      </div>
    </>
  );
};

export default Banner;
