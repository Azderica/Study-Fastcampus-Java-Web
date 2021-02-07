package kr.co.fastcampus.cli;

import kr.co.fastcampus.cli.nullsafe.NonNullBean;
import kr.co.fastcampus.cli.nullsafe.Person2;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

@Slf4j
class AopMain {
	public static void main(String[] args) throws SQLException {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(AppConfig.class);
		context.register(AopConfig.class);
		context.scan("kr.co.fastcampus.cli.nullsafe");
		context.refresh();
		AopDao dao = context.getBean(AopDao.class);
		dao.insert();
		dao.printSelect();
		val person2 = context.getBean(Person2.class);
		person2.setFullName("hello");
		System.out.println(person2);
		val nonNullBean = context.getBean(NonNullBean.class);
		nonNullBean.getA(null);
		context.close();
	}
}