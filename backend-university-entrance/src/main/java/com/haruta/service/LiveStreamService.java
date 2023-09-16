/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.haruta.service;

import com.haruta.dto.LivestreamDto;
import com.haruta.pojo.Livestream;
import java.util.List;
import java.util.Map;

/**
 *
 * @author HP
 */
public interface LiveStreamService {
    List<Livestream> getLivestreams();
    List<Livestream> getFullLivestreams(Map<String, String> params);
    
    
    Livestream create(Livestream livestream, int recruitmentId);

    Livestream update(Livestream livestream);

    Boolean delete(int livestreamId);

    Livestream findLivestreamById(int livestreamId);
    
    Livestream addLivestream (LivestreamDto livestreamDto, int recruitmentId);
    Livestream updateLivestream (LivestreamDto livestreamDto, int recruitmentId, int livestreamId);
}
