package kr.co.fastcampus.cli;

import lombok.val;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import java.io.IOException;
import java.util.Arrays;

public class ResourceMain {
    public static void main(String[] args) throws IOException {
        val context = new AnnotationConfigApplicationContext();
        context.refresh();
        val resource = context.getResources("classpath*:**/*");
        Arrays.stream(resource).forEach(System.out::println);



    }
}
