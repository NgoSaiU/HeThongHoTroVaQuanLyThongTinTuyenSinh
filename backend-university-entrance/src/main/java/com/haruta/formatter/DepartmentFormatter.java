/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.haruta.formatter;

import com.haruta.pojo.Department;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author nguye
 */
public class DepartmentFormatter implements Formatter<Department>{

    @Override
    public String print(Department d, Locale locale) {
        return String.valueOf(d.getId());
    }

    @Override
    public Department parse(String dId, Locale locale) throws ParseException {
        return new Department(Integer.parseInt(dId));
    }
    
    
}
