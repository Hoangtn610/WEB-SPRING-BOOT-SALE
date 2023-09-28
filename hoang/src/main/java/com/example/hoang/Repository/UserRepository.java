package com.example.hoang.Repository;

import com.example.hoang.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    List<Users> findByUserNameAndPasdsWord(String userName, String password);
    Users findUsersByUserName(String userName);

    @Override
    <S extends Users> S save(S entity);
}
