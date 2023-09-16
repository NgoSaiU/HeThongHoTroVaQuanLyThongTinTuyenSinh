/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.haruta.repository;

import com.haruta.pojo.News;
import java.util.List;
import java.util.Map;

/**
 *
 * @author nguye
 */
public interface NewRepository {
    List<News> getNews(Map<String, String> params);

    List<News> getNewsByRecruitment (int recruitmentId);

    int countNews();
    
     
    News save(News news);

    News update(News news);

    Boolean delete(News news);

    News findNewsById(int id);


}
