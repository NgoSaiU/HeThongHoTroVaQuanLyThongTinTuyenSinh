/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.haruta.controllers;

import com.haruta.dto.BannerDto;
import com.haruta.dto.LivestreamDto;
import com.haruta.pojo.Banner;
import com.haruta.pojo.Livestream;
import com.haruta.service.BannerService;
import com.haruta.service.LiveStreamService;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author HP
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class ApiLiveStreamController {

    @Autowired
    private LiveStreamService liveStreamService;

    //loi
    @GetMapping("/livestreams")
    @CrossOrigin
    public ResponseEntity<List<Livestream>> list() {
        return new ResponseEntity<>(this.liveStreamService.getLivestreams(), HttpStatus.OK);
    }

    @GetMapping("/livestreamsFull")
    @CrossOrigin
    public ResponseEntity<List<Livestream>> listFull(Model model, @RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.liveStreamService.getFullLivestreams(params), HttpStatus.OK);
    }

    //them
    @PostMapping("/livestreams/{recruitmentId}")
    @CrossOrigin
    public ResponseEntity<?> createBanner(@RequestBody @Valid Livestream livestream, @PathVariable("recruitmentId") int recrId) {
        Livestream livestreamSave = liveStreamService.create(livestream, recrId);
        return new ResponseEntity<>(livestreamSave, HttpStatus.CREATED);
    }

    //sua
    @PostMapping("/livestreams/{recruitmentId}/livestream/{livestreamid}")
    @CrossOrigin
    public ResponseEntity<?> updateBanner(@RequestBody @Valid Livestream livestream, @PathVariable("recruitmentId") int recrId, @PathVariable("livestreamid") int livestreamId) {
//        Banner bannerSave = banerService.update(bannerId);
//            return new ResponseEntity<>(bannerSave, HttpStatus.CREATED);
        return null;
    }

    //xoa
    @DeleteMapping("/livestream/delete/{id}/")
    @CrossOrigin
    public ResponseEntity<?> deleteLivestream(@PathVariable(value = "id") int id) {
//        return new ResponseEntity..body("You don not have permission to delete this comment");
//        return new ResponseEntity<>("Delete successfully!", HttpStatus.NO_CONTENT);
        Boolean del = this.liveStreamService.delete(id);
        if (del) {
            return new ResponseEntity<>("Delete successfully!", HttpStatus.NO_CONTENT);
        } else {
            return ResponseEntity.badRequest().body("You don not have permission to delete this comment");
        }
    }

    @PostMapping("/add-livestream/{idRecruitment}/")
    public ResponseEntity<?> createLivestream(@RequestBody @Valid LivestreamDto livestreamDto, @PathVariable("idRecruitment") int idRecruitment) {
        Livestream livestreamSaved = liveStreamService.addLivestream(livestreamDto, idRecruitment);
        return new ResponseEntity<>(livestreamSaved, HttpStatus.CREATED);
// 
    }

    @PutMapping("/update-livestream/{idRecruitment}/{idLivestream}/")
    public ResponseEntity<?> uppdateLivestream(@RequestBody @Valid LivestreamDto livestreamDto, @PathVariable("idRecruitment") int idRecruitment, @PathVariable("idLivestream") int idLivestream) {
        Livestream livestreamSaved = liveStreamService.updateLivestream(livestreamDto, idRecruitment, idLivestream);
        return new ResponseEntity<>(livestreamSaved, HttpStatus.OK);
// 
    }
}
