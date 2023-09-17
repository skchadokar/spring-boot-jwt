package com.example.postgresdb.service;

import com.example.postgresdb.models.DemoUser;
import com.example.postgresdb.repo.DemoUserRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements  IUserService{

  @Autowired
  DemoUserRepo demoUserRepo;
  @Override
  public List<DemoUser> getAllUsers() {
    return demoUserRepo.findAll();
  }

  @Override
  public DemoUser saveUsers(DemoUser user) {
    return demoUserRepo.save(user);
  }

  @Override
  public void delUsers(Long id) {
    demoUserRepo.deleteById(id);
  }

  @Override
  public List<DemoUser> getUsersByAge(String age) {
    return demoUserRepo.findByAge(age);
  }

  @Override
  public List<DemoUser> getUsersByAgeAndName(String age, String name) {
    return demoUserRepo.findByAgeAndName(age,name);
  }
}
