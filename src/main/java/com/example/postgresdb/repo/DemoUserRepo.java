package com.example.postgresdb.repo;

import com.example.postgresdb.models.DemoUser;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemoUserRepo extends JpaRepository<DemoUser, Long> {

  List<DemoUser> findByAge(String age);

  List<DemoUser> findByAgeAndName(String age, String name);
}
