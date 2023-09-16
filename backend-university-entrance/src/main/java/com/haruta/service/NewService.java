/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.haruta.service;

import com.haruta.dto.NewsDto;
import com.haruta.pojo.News;
import java.util.List;
import java.util.Map;

/**
 *
 * @author nguye
 */
public interface NewService {

    List<News> getNews(Map<String, String> params);

    List<News> getNewsByRecruitment(int recruitmentId);

    int countNews();

//     News create(News news, int newsId);
    News update(News news);

    Boolean delete(int newsId);

    News findNewsById(int newsId);

    News addNews(NewsDto newsDto, int recruitmentId);

    News updateNews(NewsDto newsDto,int recruitmentId, int newsId);

}
