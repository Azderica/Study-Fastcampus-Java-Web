package com.myepark.project.repository;

import com.myepark.project.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByName(String name);

    List<Person> findByBlockIsNull();

    List<Person> findByBloodType(String bloodType);

    @Query(value = "Select person from Person person where person.birthday.monthOfBirthday = :monthOfBirthDay")
    List<Person> findByMonthOfBirthday(@Param("monthOfBirthDay") int monthOfBirthday);

    @Query(value = "Select * from Person person where person.deleted = true", nativeQuery = true)
    List<Person> findPeopleDeleted();
}
