/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.haruta.controllers;

import com.haruta.components.JwtService;
import com.haruta.dto.UserDto;
import com.haruta.pojo.User;
import com.haruta.service.UserService;
import java.security.Principal;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author nguye
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class ApiUserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> list(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("user", new User());
        return new ResponseEntity<>(this.userService.getUsers(params), HttpStatus.OK);
    }

    @GetMapping("/countusers")
    public ResponseEntity<Integer> count() {
        return new ResponseEntity<>(this.userService.countUser(), HttpStatus.OK);
    }

//    @PostMapping("/users")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void add(@ModelAttribute(value = "user") User u) {
//        this.userService.addOrUpdateUser(u);
//    }
    //
    @PostMapping("/login/")
    @CrossOrigin
    public ResponseEntity<String> login(@RequestBody User user) {
        if (this.userService.authUser(user.getUsername(), user.getPassword()) == true) {
            String token = this.jwtService.generateTokenLogin(user.getUsername());

            return new ResponseEntity<>(token, HttpStatus.OK);
        }

        return new ResponseEntity<>("error", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/test/")
    @CrossOrigin(origins = {"127.0.0.1:5500"})
    public ResponseEntity<String> test(Principal pricipal) {
        return new ResponseEntity<>("SUCCESSFUL", HttpStatus.OK);
    }

    //them user
    @PostMapping(path = "/users/",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @CrossOrigin
    public ResponseEntity<User> addUser(@RequestParam Map<String, String> params, @RequestPart MultipartFile avatar) {
        User user = this.userService.addUser(params, avatar);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

//    
//    @PostMapping(path = "/usersTest/",
//            produces = {MediaType.APPLICATION_JSON_VALUE})
//    @CrossOrigin
//    public ResponseEntity<User> addUserTest(@RequestParam Map<String, String> params) {
//        User user = this.userService.addUserTest(params);
//        return new ResponseEntity<>(user, HttpStatus.CREATED);
//    } 
//     
    @GetMapping(path = "/current-user/", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<User> details(Principal user) {
        User u = this.userService.getUserByUn(user.getName());
        return new ResponseEntity<>(u, HttpStatus.OK);
    }

    //xoa
    @DeleteMapping("/users/delete/{id}/")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id") int id) {
//        return new ResponseEntity..body("You don not have permission to delete this comment");
//        return new ResponseEntity<>("Delete successfully!", HttpStatus.NO_CONTENT);
        Boolean del = this.userService.delete(id);
        if (del) {
            return new ResponseEntity<>("Delete successfully!", HttpStatus.NO_CONTENT);
        } else {
            return ResponseEntity.badRequest().body("You don not have permission to delete this comment");
        }
    }

    @PostMapping("/add-user")
    public ResponseEntity<?> createPost(@RequestBody @Valid UserDto userDto, @RequestPart MultipartFile avatar) {
        User userDtoSaved = userService.possUser(userDto, avatar);
        return new ResponseEntity<>(userDtoSaved, HttpStatus.CREATED);
// 
    }

    @PutMapping("/update-user/{idUser}/")
    public ResponseEntity<?> uppdateUser(@RequestBody @Valid UserDto userDto, @PathVariable("idUser") int userId, @RequestPart MultipartFile avatar) {
        User userDtoSaved = userService.updateUser(userDto, userId, avatar);
        return new ResponseEntity<>(userDtoSaved, HttpStatus.CREATED);
// 
    }

}
