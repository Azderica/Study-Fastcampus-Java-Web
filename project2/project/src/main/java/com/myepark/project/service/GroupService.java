package com.myepark.project.service;

import com.myepark.project.controller.dto.GroupDto;
import com.myepark.project.domain.Group;
import com.myepark.project.domain.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class GroupService {
    public Page<Group> getAll(Pageable pageable) {
        return null;
    }

    public Group getGroup(Long id) {
        return null;
    }

    public void postGroup(GroupDto groupDto) {
    }

    public void modifyGroup(Long id, String description) {
    }

    public List<Person> getPeopleInGroup(Long id) {
        return null;
    }

    public void putPersonInGroup(Long id, Long personId) {
    }

    public void delete(Long id) {
    }
}
