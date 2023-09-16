/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.haruta.controllers;

import com.haruta.pojo.Department;
import com.haruta.pojo.User;
import com.haruta.service.DepartmentService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author nguye
 */
@RestController
@RequestMapping("/api")

public class ApiDepartmentController {
    @Autowired
    private DepartmentService dpmService;
    
//    @GetMapping("/departments")
//    public ResponseEntity<List<Department>> list(@RequestParam Map<String, String> params) {
//        return new ResponseEntity<>(this.dpmService.getDpm(params), HttpStatus.OK);
//    }
    
    @GetMapping("/departments")
    @CrossOrigin
    public ResponseEntity<List<Department>> list(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("departments", new Department());
        return new ResponseEntity<>(this.dpmService.getDpm(params), HttpStatus.OK);
    }
    
     //chi tiet san pham
    @RequestMapping(path = "/departments/{departmentId}/", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<Department> details(@PathVariable(value = "departmentId") int id) {
        return new ResponseEntity<>(this.dpmService.getDepartmentById(id), HttpStatus.OK);
    }
    
    
    @DeleteMapping("/departments/delete/{id}/")
    @CrossOrigin
    public  ResponseEntity<?> deleteProduct (@PathVariable (value = "id") int id) {
//        return new ResponseEntity..body("You don not have permission to delete this comment");
//        return new ResponseEntity<>("Delete successfully!", HttpStatus.NO_CONTENT);
        Boolean del = this.dpmService.delete(id);  
        if (del) {
            return new ResponseEntity<>("Delete successfully!", HttpStatus.NO_CONTENT);
        } else {
            return ResponseEntity.badRequest().body("You don not have permission to delete this comment");
        }
    }
    
    
    
    
}
