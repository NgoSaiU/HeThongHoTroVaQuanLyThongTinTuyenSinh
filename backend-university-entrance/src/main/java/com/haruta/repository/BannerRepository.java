/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.haruta.repository;


import com.haruta.pojo.Banner;
import java.util.List;
import java.util.Map;

/**
 *
 * @author nguye
 */
public interface BannerRepository {
    List<Banner> getBanner();
    List<Banner> getFullBanner(Map<String, String> params);
    
    Banner save(Banner banner);

    Banner update(Banner banner);

    Boolean delete(Banner banner);

    Banner findBannerById(int id);
    
    

}
