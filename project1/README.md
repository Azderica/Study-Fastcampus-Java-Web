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

### Entity

- Camel Case :  단어를 표기할 때, 첫 문자는 소문자로 시작하고 띄어쓰기 대신 대문자로 단어를 구분하며 일반적으로 Java의 변수를 선언할때 사용합니다.
  - ex) phoneNumber, createdAt, updatedAt
- Snake Case : 단어를 표기할 때, 모두 소문자로 표기하며 띄어쓰기 대신 (_) 로 표기, DB 컬럼에 사용
  - ex) phone_number, created_at, updated_at

API를 정의하기에 따라 다르지만, 주로 API 통신 규격에는 Snake Case를 주로 사용합니다.

Entity? JPA에서는 테이블을 자동으로 생성해주는 기능 존재 (DB table == JPA Entity)

| Annoation         | 용도                           |
| ----------------- | ------------------------------ |
| `@Entity`         | 해당 Class가 Entity임을 명시   |
| `@Table`          | 실제 DB테이블의 이름을 명시    |
| `@Id`             | Index primary key를 명시       |
| `@Column`         | 실제 DB Column의 이름을 명시   |
| `@GeneratedValue` | Primary key 식별키의 전략 설정 |

### Repository

따로 선언하지 않아도 기본적인 CRUD를 선언해줌.

어노테이션 `@Repository`  +  상속으로 `extends JpaRepository<T, ID>`를 선언함으로4서 사용할 수 있음.

### JPA 연관관계 설정 배우기

| 관계   | Annotation    |
| ------ | ------------- |
| 일대일 | `@OneToOne`   |
| 일대다 | `@OneToMany`  |
| 다대일 | `@ManyToOne`  |
| 다대다 | `@ManyToMany` |

