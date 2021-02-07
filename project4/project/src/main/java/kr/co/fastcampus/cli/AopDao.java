package kr.co.fastcampus.cli;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.Connection;
import java.sql.SQLException;

@Slf4j
public class AopDao {
    private Connection connection;

    @Autowired
    public AopDao(Connection connection) {
        this.connection = connection;
    }

    @PostConstruct
    void init() throws SQLException {
        log.info("dao init");
        val statement = connection.createStatement();
        statement.execute("drop table if exists member");
        statement.execute("create table member(id int auto_increment, username varchar(255) not null, password varchar(255) not null, primary key(id))");
    }

    @PreDestroy
    void destroy() {
        log.info("dao destroy");
    }

    public void insert() throws SQLException {
        val statement = connection.createStatement();
        statement.executeUpdate("insert into member(username, password) values('boojongmin', '1234')");
    }

    public void printSelect() throws SQLException {
        val statement = connection.createStatement();
        val resultSet = statement.executeQuery("select id, username, password from member");
        while(resultSet.next()) {
            var member = new Member(resultSet.getString("username"), resultSet.getString("password"));
            log.info(member.toString());
        }
    }
}
