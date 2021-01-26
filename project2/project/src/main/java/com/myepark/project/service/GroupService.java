package com.myepark.project.service;

import com.myepark.project.controller.dto.GroupDto;
import com.myepark.project.domain.Group;
import com.myepark.project.domain.Person;
import com.myepark.project.exception.GroupNotFoundException;
import com.myepark.project.exception.PersonNotFoundException;
import com.myepark.project.repository.GroupRepository;
import com.myepark.project.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private PersonRepository personRepository;

    public Page<Group> getAll(Pageable pageable) {
        return groupRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public Group getGroup(Long id) {
        return groupRepository.findById(id).orElse(null);
    }

    @Transactional
    public void postGroup(GroupDto groupDto) {
        Group group = new Group();
        group.set(groupDto);
        groupRepository.save(group);
    }

    public void modifyGroup(Long id, String description) {
        Group group = groupRepository.findById(id).orElseThrow(GroupNotFoundException::new);
        group.setDescription(description);
        groupRepository.save(group);
    }

    public List<Person> getPeopleInGroup(Long id) {
        Group group = groupRepository.findById(id).orElseThrow(GroupNotFoundException::new);
        return group.getPersonList();
    }

    public void putPersonInGroup(Long id, Long personId) {
        Group group = groupRepository.findById(id).orElseThrow(GroupNotFoundException::new);
        Person person = personRepository.findById(personId).orElseThrow(PersonNotFoundException::new);
        person.setGroup(group);
    }
}
