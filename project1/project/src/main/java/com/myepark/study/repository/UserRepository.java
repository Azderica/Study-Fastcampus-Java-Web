package com.myepark.study.repository;

import com.myepark.study.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findFirstByPhoneNumberOrderByIdDesc(String phoneNumber);
}
