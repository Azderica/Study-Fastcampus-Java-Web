package kr.co.fastcampus.cli;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

@Slf4j
public class A {
    private B b;

    public A(B b) {
        this.b = b;
    }

    void init() {
        log.error("A post construct : " + b);
    }

    void destroy() {
        log.error("A pre destroy");
    }
}
