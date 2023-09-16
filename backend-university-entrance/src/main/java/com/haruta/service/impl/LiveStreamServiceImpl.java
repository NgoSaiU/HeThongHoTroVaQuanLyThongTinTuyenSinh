/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.haruta.service.impl;

import com.haruta.dto.LivestreamDto;
import com.haruta.exception.ResourceNotFoundException;

import com.haruta.pojo.Livestream;
import com.haruta.pojo.Recruitment;
import com.haruta.repository.LiveStreamRepository;
import com.haruta.repository.RecruitmentRepository;
import com.haruta.service.LiveStreamService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class LiveStreamServiceImpl implements LiveStreamService {

    @Autowired
    private LiveStreamRepository liveStreamRepositoryRepo;

    @Autowired
    private RecruitmentRepository recuRepository;

    @Override
    public List<Livestream> getLivestreams() {
        return this.liveStreamRepositoryRepo.getLivestreams();
    }

    @Override
    public List<Livestream> getFullLivestreams(Map<String, String> params) {
        return this.liveStreamRepositoryRepo.getFullLivestreams(params);
    }

    @Override
    public Livestream create(Livestream livestream, int recruitmentId) {
        return null;
    }

    @Override
    public Livestream update(Livestream livestream) {
        return null;
    }

    @Override
    public Boolean delete(int livestreamId) {
        Livestream livestream = liveStreamRepositoryRepo.findLivestreamById(livestreamId);
        if (livestream != null) {
            liveStreamRepositoryRepo.delete(livestream);
            return true;
        }
        return false;
    }

    @Override
    public Livestream findLivestreamById(int livestreamId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Livestream addLivestream(LivestreamDto livestreamDto, int recruitmentId) {
        Recruitment recruitment = recuRepository.findRecruitmentById(recruitmentId);

        Livestream livestream = new Livestream();
        livestream.setName(livestreamDto.getName());
        livestream.setDescription(livestreamDto.getDescription());
        livestream.setStartDate(livestreamDto.getStartDate());
        livestream.setStartTime(livestreamDto.getStartTime()); 
        livestream.setRecruitmentId(recruitment);

        this.liveStreamRepositoryRepo.save(livestream);
        return livestream;
    }

    @Override
    public Livestream updateLivestream(LivestreamDto livestreamDto, int recruitmentId, int livestreamId) {
        Recruitment recruitment = recuRepository.findRecruitmentById(recruitmentId);
        
        Livestream livestream = liveStreamRepositoryRepo.findLivestreamById(livestreamId);
        if (livestream == null) {
            throw new ResourceNotFoundException("Post", "id", livestreamId);
        }

        livestream.setName(livestreamDto.getName());
        livestream.setDescription(livestreamDto.getDescription());
        livestream.setStartDate(livestreamDto.getStartDate());
        livestream.setStartTime(livestreamDto.getStartTime()); 
        livestream.setRecruitmentId(recruitment);
      

        this.liveStreamRepositoryRepo.update(livestream);
        return livestream;
    }

}
