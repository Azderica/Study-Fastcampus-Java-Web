# Java Project 2



### Anotation - Lombok

```java
@EqualsAndHashCode
// 해당 Anotation을 통해 다른 두 객체의 값을 정상적으로 비교가능
```



### JPA Relation

#### cascade

역속성 전이, 부모 엔티티를 저장할때 자식 엔티티도 함께 저장된다.



#### fetch

![image](https://user-images.githubusercontent.com/42582516/105488188-9c5c4380-5cf4-11eb-8925-152521626ac7.png)

FetchType.EAGER : Default, 즉시 로딩

FetchType.LAZY : 지연 로딩



#### optional

false : 객체에 null이 들어갈 수 있습니다.

true : 반드시 값이 필요합니다.



#### orphanRemoval

참조가 끊어지면 DB에서 삭제되게 설정할 수 있습니다. 

`@OneToOne` 에서는 true인 경우, 엔티티가 삭제될 때 연관된 엔티티도 삭제하고 DB에서도 삭제하라는 의미입니다.

`@OneToMany` 의 경우에는 여러가지 타입이 있으며 그에 따른 기능을 처리할 수 있습니다. 즉 `People` 이라는 클래스에서 `Block` 이라는 값을 가지고 있을 때, 해당 연결이 끊길 때 Block이 사라지게 할 수 있습니다.



### @Query Method

![image](https://user-images.githubusercontent.com/42582516/105487940-412a5100-5cf4-11eb-83ef-72e3fc6c9989.png)



`jpaqueryDsl` 에서 `native query = true`  로 설정하면, 실제 query 문을 쓸 수도 있다.





---

해당 프로젝트에서 나온 개념



### 1-cycle

- JPA
  - Entity
  - @OntToOne Relation
    - CascadeType
    - FetchType
    - Optional, orphanRemoval
  - QueryMethod
  - @Embedded
  - @Valid
  - @Query
  - @Where (for Soft-Delete)
  - Data.sql
- SpringMVC
  - @GetMapping
  - @PostMapping
  - @PutMapping
  - @PatchMapping
  - @DeleteMapping
  - @PathVariable
  - @RequestBody
- Lombok
  - @Getter
  - @Setter
  - @ToString
  - @Constructor
  - @EqualsAndHashCode
  - @Data
- SpringbootTest
- Java8
  - Stream
  - Filter
  - Map



### 2-cycle

- SpringMVC
  - CustomJsonSerializer
- SpringTEst
  - MockMvc Test
  - Matcher
  - Junit5
- MockTest
  - Mockito
  - CustomArgumentMatcher
- Exception Handling
  - CustomException
  - ExceptionHandler
  - GlobalExceptionHandler
- Parameter Validator
  - @NotEmpty
  - @NotBlank
  - @Valid
- Paging
  - Pageable
  - Page<T>



### 향후 공부하면 좋을 개념

- FrontEnd 개발
  - Web
    - VueJs, ReactJs
  - App
    - Android App[
    - IOS App
- DB 연동
  - MySQL
  - MongoDB
- Spring(Boot)의 중금 활용
  - 추가적인 설정
  - Customizing 설정
- JPA 중급 활용
  - 다양한 Relation
  - QueryDSL / Jooq
- 로직의 확장
  - 추가적인 스펙

