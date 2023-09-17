package com.example.postgresdb.controllers;

import com.example.postgresdb.models.DemoUser;
import com.example.postgresdb.service.IUserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @Autowired
  IUserService iUserService;

  @GetMapping("/users")
  public List<DemoUser> getUsers(){
    return iUserService.getAllUsers();
  }


  @GetMapping("/users/{age}")
  public List<DemoUser> getUsersByAge(@PathVariable String age){
    return iUserService.getUsersByAge(age);
  }

  @GetMapping("/users/{age}/{name}")
  public List<DemoUser> getUsersByAgeAndName(@PathVariable String age,@PathVariable String name){
    return iUserService.getUsersByAgeAndName(age,name);
  }

  @PostMapping("/users")
  public DemoUser saveUsers(@RequestBody DemoUser user){
    return iUserService.saveUsers(user);
  }


  @DeleteMapping("/users/{id}")
  public List<DemoUser> delUsers(@PathVariable Long id){
    iUserService.delUsers(id);
    return iUserService.getAllUsers();
  }


}
