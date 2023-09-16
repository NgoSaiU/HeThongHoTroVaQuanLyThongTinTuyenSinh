/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.haruta.formatter;

import com.haruta.pojo.Major;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author nguye
 */
public class MajorFormatter implements Formatter<Major>{
    @Override
    public String print(Major m, Locale locale) {
        return String.valueOf(m.getId());
    }

    @Override
    public Major parse(String mId, Locale locale) throws ParseException {
        return new Major(Integer.parseInt(mId));
    }
    
}
