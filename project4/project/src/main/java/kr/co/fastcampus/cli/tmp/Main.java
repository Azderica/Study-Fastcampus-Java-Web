package kr.co.fastcampus.cli.tmp;

import lombok.val;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.Validator;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.TimeZone;

public class Main {
    public static void main(String[] args) {
        // 참조 https://www.logicbig.com/how-to/code-snippets/jcode-spring-framework-localvalidatorfactorybean.html
        Locale.setDefault(Locale.US);
        TimeZone.setDefault(TimeZone.getTimeZone("Mexico/BajaNorte"));
        System.out.println(LocalDateTime.now());

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext( Config.class);
        val validator = context.getBean(Validator.class);
        val personForm = new PersonForm();
        val validate = validator.validate(personForm);
        System.out.println(validate);

//        val validatorFactoryBean = new LocalValidatorFactoryBean();
//        val validator = validatorFactoryBean.getValidator();
//        Set<ConstraintViolation<PersonForm>> set = validator.validate(new PersonForm());
//        System.out.println(set);
//        val validator = new PersonValidator();
//        val p = new Person();
        // https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/validation/Errors.html
//        val e = new BindException(p, "person");
//        val violations = validator.validate(p);
//        System.out.println(e);
    }
}

@Configuration
class Config {
    @Bean
    public Validator validator() {
        return new LocalValidatorFactoryBean();
    }
}
