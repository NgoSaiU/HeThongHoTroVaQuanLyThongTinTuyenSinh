/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.haruta.repository;

import com.haruta.pojo.Livestream;
import java.util.List;
import java.util.Map;
/**
 *
 * @author HP
 */
public interface LiveStreamRepository {
     List<Livestream> getLivestreams();
    List<Livestream> getFullLivestreams(Map<String, String> params);
    
    Livestream save(Livestream livestream);

    Livestream update(Livestream livestream);

    Boolean delete(Livestream livestream);

    Livestream findLivestreamById(int id);
    
}
