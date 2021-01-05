# Project1. Admin Page

## Version

- Java8
- Gradle
- DB : MySQL



## Rest API

- HTTP 프로토콜에 있는 Method를 활용한 아키텍처 스타일
- HTTP Method를 통하여 Resource를 처리
- CRUD를 통한 Resource 조작을 할 때 사용

| HTTP Method | 동작                   | URL 형태   |
| ----------- | ---------------------- | ---------- |
| GET         | 조회 (select * read)   | /user/{id} |
| POST        | 생성 (create)          | /user      |
| PUT / PATCH | 수정 (update) * create | /user      |
| DELETE      | 삭제 (delete)          | /user/{1}  |



> Spring 구성

![image](https://user-images.githubusercontent.com/42582516/103657578-69544900-4fad-11eb-8510-3ddfb4f1c481.png)



## JPA

- ORM(Object Relational Mapping)으로, RDB 데이터 베이스의 정보를 객체지향으로 손쉽게 활용할 수 있도록 도와주는 도구
- Object(자바 객체)와 Relation(관계형 데이터베이스) 둘간의 맵핑을 통해서 보다 손쉽게 적용할 수 있는 기술을 제공
- 쿼리에 집중하기 보다는 객체에 집중함으로서, 조금 더 프로그래밍 적으로 많이 활용 가능

