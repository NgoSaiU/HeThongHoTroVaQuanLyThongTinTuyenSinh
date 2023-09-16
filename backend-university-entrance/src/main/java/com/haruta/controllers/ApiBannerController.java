/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.haruta.controllers;

import com.haruta.dto.BannerDto;
import com.haruta.pojo.Banner;
import com.haruta.service.BannerService;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author nguye
 */
@Controller
@RequestMapping("/api")
@CrossOrigin
public class ApiBannerController {

    @Autowired
    private BannerService banerService;

    @GetMapping("/banners")
    @CrossOrigin
    public ResponseEntity<List<Banner>> list() {
        return new ResponseEntity<>(this.banerService.getBanner(), HttpStatus.OK);
    }

    @GetMapping("/bannersFull")
    @CrossOrigin
    public ResponseEntity<List<Banner>> listFull(Model model, @RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.banerService.getFullBanner(params), HttpStatus.OK);
    }

    //them
    @PostMapping("/banners/{recruitmentId}")
    @CrossOrigin
    public ResponseEntity<?> createBanner(@RequestBody @Valid Banner banner, @PathVariable("recruitmentId") int recrId) {
        Banner bannerSave = banerService.create(banner, recrId);
        return new ResponseEntity<>(bannerSave, HttpStatus.CREATED);
    }

    //sua
    @PostMapping("/banners/{recruitmentId}/banner/{bannerId}")
    @CrossOrigin
    public ResponseEntity<?> updateBanner(@RequestBody @Valid Banner banner, @PathVariable("recruitmentId") int recrId, @PathVariable("bannerId") int bannerId) {
//        Banner bannerSave = banerService.update(bannerId);
//            return new ResponseEntity<>(bannerSave, HttpStatus.CREATED);
        return null;
    }

    //xoa
    @DeleteMapping("/banner/delete/{id}/")
    @CrossOrigin
    public ResponseEntity<?> deleteBanner(@PathVariable(value = "id") int id) {
//        return new ResponseEntity..body("You don not have permission to delete this comment");
//        return new ResponseEntity<>("Delete successfully!", HttpStatus.NO_CONTENT);
        Boolean del = this.banerService.delete(id);
        if (del) {
            return new ResponseEntity<>("Delete successfully!", HttpStatus.NO_CONTENT);
        } else {
            return ResponseEntity.badRequest().body("You don not have permission to delete this comment");
        }
    }

    @PostMapping("/add-banner/{idRecruitment}/")
    public ResponseEntity<?> createBanner(@RequestBody @Valid BannerDto bannerDto, @PathVariable("idRecruitment") int idRecruitment) {
        Banner bannerSaved = banerService.addBanner(bannerDto,idRecruitment);
        return new ResponseEntity<>(bannerSaved, HttpStatus.CREATED);
// 
    }

    @PutMapping("/update-banner/{idRecruitment}/{idBanner}/")
    public ResponseEntity<?> uppdateUser(@RequestBody @Valid BannerDto bannerDto,@PathVariable("idRecruitment") int idRecruitment , @PathVariable("idBanner") int idBanner) {
        Banner bannerSaved = banerService.updateBanner(bannerDto, idRecruitment,idBanner);
        return new ResponseEntity<>(bannerSaved, HttpStatus.OK);
// 
    }
}
    