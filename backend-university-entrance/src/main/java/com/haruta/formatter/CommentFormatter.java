/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.haruta.formatter;

import com.haruta.pojo.Comment;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author nguye
 */
public class CommentFormatter implements Formatter<Comment>{

    @Override
    public String print(Comment c, Locale locale) {
        return String.valueOf(c.getId());
    }

    @Override
    public Comment parse(String cId, Locale locale) throws ParseException {
        return new Comment(Integer.parseInt(cId));
    }
    
}
