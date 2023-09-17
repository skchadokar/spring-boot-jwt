package com.example.postgresdb.service;

import com.example.postgresdb.models.DemoUser;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {

  List<DemoUser> getAllUsers();

  DemoUser saveUsers(DemoUser user);

  void delUsers(Long id);

  List<DemoUser> getUsersByAge(String age);

  List<DemoUser> getUsersByAgeAndName(String age, String name);
}
