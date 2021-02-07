# Project 3

## 프로젝트 소개

레스토랑 예약시스템으로 아래의 개의 서비스로 구성됩니다.

- Admin(관리자) API / WEB
- Customer(손님) API / WEB
- Login(로그인) API / WEB
- Restaurant(레스토랑) API / WEB

또한 해당 API는 `common` 의 공통 모듈을 사용합니다.

각 페이지 마다 보여주는 서비스는 node로 간략하게 보여줍니다.



## 프로젝트에서 나오는 기술

- Springboot
- REST API
- Code Refactoring
- Mock, Mockito, JUnit
- Filtering
- JWT
- Multi Modules



## 프로젝트 실행 방법

- Jar 파일로 만들기

```bash
./gradlew bootJar
```

- docker 실행

```bash
docker-compose up
```





## References 

- [JWT 관련 링크](https://jwt.io/)
- [DB 오류 : Wrong User name and Password](https://hothoony.tistory.com/890)
  - h2에 패스워드 다 설정해놓고, 다른 프로젝트에서 아이디랑 패스워드 까먹으면 사용을 못함
  - 기존의 h2 db를 삭제해야함.

- **io.jswonwebtoken에 빨간줄 발생 시**
  - 아예 gradle 을 업그레이드하고
    - `brew upgrade grade`
  - **File > Invalid Caches / Restart** 를 해서 다시 시작하니 반영되었습니다.

