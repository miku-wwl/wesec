package com.weilai.sec.controller;

import com.weilai.sec.entity.User;
import com.weilai.sec.repository.UserRepository;
import com.weilai.sec.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    public UserService userService;

    @Autowired
    public UserRepository userRepository;

//    @GetMapping("/list")
//    public List<User> getList() {
//        return userRepository.findAll();
//    }
//
//    @PostMapping("/add")
//    public void add(@RequestBody User user) {
//        userService.saveUserDetails(user);
//    }

    //用户必须有 ADMIN 角色 并且 用户名是 admin 才能访问此方法
    @PreAuthorize("hasRole('ADMIN') and authentication.name == 'admim'")
    @GetMapping("/list")
    public List<User> getList(){
        return userService.findAll();
    }

    //用户必须有 USER_ADD 权限 才能访问此方法
    @PreAuthorize("hasAuthority('USER_ADD')")
    @PostMapping("/add")
    public void add(@RequestBody User user){
        userService.saveUserDetails(user);
    }
}