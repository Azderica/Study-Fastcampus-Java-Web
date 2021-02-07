package kr.co.fastcampus.cli;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.util.StopWatch;

import java.sql.Connection;
import java.sql.SQLException;

@Configuration
@EnableAspectJAutoProxy
@Aspect
@Slf4j
public class AopConfig {
    private final Connection connection;

    public AopConfig(Connection connection) {
        this.connection = connection;
    }

    @Around("execution(* insert(..))")
    public void doAroundInsert(ProceedingJoinPoint pjp) throws SQLException {
        log.error("aop before");
        StopWatch clock = new StopWatch("Profiling for 'Person");
        connection.setAutoCommit(false);
        try {
            log.error("aop target method ");
            clock.start();
            pjp.proceed();
        } catch (Throwable ex) {
            log.error("error");
//            log.error("error", ex);
            connection.rollback();
            return;
        } finally {
            clock.stop();
            System.out.println(clock.prettyPrint());
        }
        log.error("aop commit");
        connection.commit();

//        connection.commit();
    }

//    @Before("execution(* insert(..))")
//    public void doBeforeInsert() throws SQLException {
//        log.error("aop before");
//        connection.setAutoCommit(false);
//    }
//
//    @After("execution(* insert(..))")
//    public void doAfterInsert() throws SQLException {
//        log.error("aop after");
//        connection.commit();
//    }
//
//    @AfterThrowing(
//            pointcut = "execution(* insert(..))",
//            throwing = "ex"
//    )
//    public void doAfterThrowingInsert(SQLException ex) throws SQLException {
//        log.error("aop after throwing");
////        log.error("aop after throwing", ex);
//        connection.rollback();
//    }
}
