package com.myepark.project.controller;

import com.myepark.project.controller.dto.GroupDto;
import com.myepark.project.domain.Group;
import com.myepark.project.domain.Person;
import com.myepark.project.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/api/group")
@RestController
public class GroupController {
    @Autowired
    private GroupService groupService;

    @GetMapping
    public Page<Group> getAll(@PageableDefault Pageable pageable) {
        return groupService.getAll(pageable);
    }

    @GetMapping("/{id}")
    public Group getGroup(@PathVariable Long id) {
        return groupService.getGroup(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void postGroup(@RequestBody GroupDto groupDto){
        groupService.postGroup(groupDto);
    }

    @PatchMapping("/{id}")
    public void modifyGroup(@PathVariable Long id, String description) {
        groupService.modifyGroup(id, description);
    }

    @GetMapping("/{id}/people")
    public List<Person> getPeopleInGroup(@PathVariable Long id) {
        return groupService.getPeopleInGroup(id);
    }

    @PutMapping("/{id}/person/{personId}")
    public void putPersonInGroup(@PathVariable Long id, @PathVariable Long personId) {
        groupService.putPersonInGroup(id, personId);
    }
}
