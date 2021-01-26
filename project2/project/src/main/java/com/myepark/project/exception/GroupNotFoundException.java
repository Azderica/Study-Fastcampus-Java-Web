package com.myepark.project.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GroupNotFoundException extends RuntimeException{
    private static final String MESSAGE = "Group Entity가 존재하지 않습니다.";

    public GroupNotFoundException(){
        super(MESSAGE);
        log.error(MESSAGE);
    }
}
