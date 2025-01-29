package com.chuwa.redbook.dao;

import com.chuwa.redbook.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String username);

    User findByEmail(String email);

    User findByFirstNameAndLastName(String firstName, String lastName);

}
