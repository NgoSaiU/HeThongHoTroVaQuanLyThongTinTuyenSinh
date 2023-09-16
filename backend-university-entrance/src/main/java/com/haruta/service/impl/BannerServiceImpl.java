/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.haruta.service.impl;

import com.haruta.dto.BannerDto;
import com.haruta.pojo.Banner;
import com.haruta.pojo.Recruitment;
import com.haruta.repository.BannerRepository;
import com.haruta.repository.RecruitmentRepository;
import com.haruta.service.BannerService;
import java.util.List;
import java.util.Map;
import com.haruta.exception.ResourceNotFoundException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author nguye
 */
@Service
public class BannerServiceImpl implements BannerService{
    @Autowired
    private BannerRepository bannerRepo;
    
    @Autowired
    private RecruitmentRepository recuRepository;

    @Override
    public List<Banner> getBanner() {
        return this.bannerRepo.getBanner();
    }

    @Override
    public Banner create(Banner banner, int recruitmentId) {
//          public CommentDto create(CommentDto commentDto, Long postId, Long userId, Long belongsCommentId) {
//        Recruitment recruitment = recuRepository.findRecruitmentById(recruitmentId);
//        if (recruitment == null) {
//            throw new ResourceNotFoundException("Recruitment", "id", recruitmentId);
//        }
////       
//        Banner bannertmp;
//     
//            bannertmp = Banner.builder()
//                    .title(banner.getTitle())
//                    .image(banner.getImage())
//                    .link(banner.getLink())
//                    .createdDate(Timestamp.valueOf(LocalDateTime.now()))
//                    .updatedDate(Timestamp.valueOf(LocalDateTime.now()))   
//                    .status(banner.getStatus())
//                    .build();
//        
//        Banner bannerResult = bannerRepo.save(bannertmp);
//        Banner bannertmp2 = Banner.builder()
//                    .title(bannerResult.getTitle())
//                    .image(bannerResult.getImage())
//                    .link(bannerResult.getLink())
//                    .createdDate(Timestamp.valueOf(LocalDateTime.now()))
//                    .updatedDate(Timestamp.valueOf(LocalDateTime.now()))   
//                    .status(bannerResult.getStatus())
//                    .build();
//        
//        return bannertmp2;

        return null;
//        
//    
    }

    @Override
    public Banner update(Banner banner) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean delete(int bannerId) {
        Banner banner = bannerRepo.findBannerById(bannerId);
        if(banner != null){
            bannerRepo.delete(banner);
            return true;
        }
        return false;
    }

    @Override
    public Banner findByBannerId(int bannerId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Banner> getFullBanner(Map<String, String> params) {
        return this.bannerRepo.getFullBanner(params);
    }

    @Override
    public Banner addBanner(BannerDto bannerDto,  int recruitmentId) {
        Recruitment recruitment = recuRepository.findRecruitmentById(recruitmentId);
        
        Banner banner  = new Banner();
        banner.setTitle(bannerDto.getTitle());
        banner.setImage(bannerDto.getImage());
        banner.setLink(bannerDto.getLink());
        banner.setCreatedDate(bannerDto.getCreatedDate());
        banner.setUpdatedDate(bannerDto.getUpdatedDate());
        banner.setStatus(bannerDto.getStatus());
        banner.setRecruitmentId(recruitment);
        
        this.bannerRepo.save(banner);
        return banner;
    }

    @Override
    public Banner updateBanner(BannerDto bannerDto, int recruitmentId, int bannerId) {
        
          Date date=java.util.Calendar.getInstance().getTime();  
        
         Recruitment recruitment = recuRepository.findRecruitmentById(recruitmentId);
          Banner banner = bannerRepo.findBannerById(bannerId);
         if (banner == null) {
            throw new ResourceNotFoundException("Post", "id", bannerId);
         }
         
        banner.setTitle(bannerDto.getTitle());
//        banner.setImage(bannerDto.getImage());
        banner.setLink(bannerDto.getLink());
//        banner.setCreatedDate(bannerDto.getCreatedDate());
        banner.setCreatedDate(date);
        banner.setUpdatedDate(bannerDto.getUpdatedDate());
        banner.setStatus(bannerDto.getStatus());
        banner.setRecruitmentId(recruitment);
        
        this.bannerRepo.update(banner);
        return banner;
         
    }
}
