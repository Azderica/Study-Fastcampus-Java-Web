package com.myepark.project.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myepark.project.controller.dto.PersonDto;
import com.myepark.project.domain.Person;
import com.myepark.project.exception.handler.GlobalExceptionHandler;
import com.myepark.project.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.transaction.Transactional;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@SpringBootTest
@Transactional
class PersonControllerTest {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @BeforeEach
    void beforeEach() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(wac)
                .alwaysDo(print())
                .build();
    }

    @Test
    void getAll() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/api/person")
                    .param("page", "1")
                    .param("size", "2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.totalPages").value(3))
                .andExpect(jsonPath("$.totalElements").value(6))
                .andExpect(jsonPath("$.numberOfElements").value(2))
                .andExpect(jsonPath("$.content.[0].name").value("dennis"))
                .andExpect(jsonPath("$.content.[1].name").value("sophia"));
    }

    @Test
    void getPerson() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/api/person/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("martin"))
                .andExpect(jsonPath("$.birthday").value("1991-08-15"));
    }

    @Test
    void postPerson() throws Exception {
        PersonDto dto = PersonDto.of("martin", "programming", "판교", LocalDate.now(), "programmer", "010-1111-2222");

        mockMvc.perform(
                MockMvcRequestBuilders.post("/api/person")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(toJsonString(dto)))
                .andExpect(status().isCreated());

        Person result = personRepository.findAll(Sort.by(Sort.Direction.DESC, "id")).get(0);

        assertAll(
                () -> assertThat(result.getName()).isEqualTo("martin")
        );
    }

    @Test
    void postPersonIfNameIsNull() throws Exception {
        PersonDto dto = new PersonDto();

        mockMvc.perform(
                MockMvcRequestBuilders.post("/api/person")
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJsonString(dto)))
                .andExpect(jsonPath("$.code").value(400))
                .andExpect(jsonPath("$.message").value("이름은 필수값입니다."));;
    }

    @Test
    void postPersonIfNameIsEmptyString() throws Exception {
        PersonDto dto = new PersonDto();
        dto.setName("");

        mockMvc.perform(
                MockMvcRequestBuilders.post("/api/person")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(toJsonString(dto)))
                .andExpect(jsonPath("$.code").value(400))
                .andExpect(jsonPath("$.message").value("이름은 필수값입니다."));;
    }

    @Test
    void postPersonIfNameIsBlankString() throws Exception {
        PersonDto dto = new PersonDto();
        dto.setName(" ");

        mockMvc.perform(
                MockMvcRequestBuilders.post("/api/person")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(toJsonString(dto)))
                .andExpect(jsonPath("$.code").value(400))
                .andExpect(jsonPath("$.message").value("이름은 필수값입니다."));;
    }

    @Test
    void modifyPerson() throws Exception {
        PersonDto dto = PersonDto.of("martin", "programming", "판교", LocalDate.now(), "programmer", "010-1111-2222");

        mockMvc.perform(
                MockMvcRequestBuilders.put("/api/person/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(toJsonString(dto)))
                .andExpect(status().isOk());

        Person result = personRepository.findById(1L).get();

        assertThat(result.getName()).isEqualTo("martin");
    }

    @Test
    void modifyPersonIfNameIsDifferent() throws Exception {
        PersonDto dto = PersonDto.of("james", "programming", "판교", LocalDate.now(), "programmer", "010-1111-2222");

        mockMvc.perform(
                MockMvcRequestBuilders.put("/api/person/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(toJsonString(dto)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.code").value(400))
                .andExpect(jsonPath("$.message").value("이름 변경이 허용되지 않습니다."));
    }

    @Test
    void modifyPersonIfPersonNotFound() throws Exception {
        PersonDto dto = PersonDto.of("martin", "programming", "판교", LocalDate.now(), "programmer", "010-1111-2222");

        mockMvc.perform(
                MockMvcRequestBuilders.put("/api/person/10")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(toJsonString(dto)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.code").value(400))
                .andExpect(jsonPath("$.message").value("Person Entity가 존재하지 않습니다."));
    }

    @Test
    void modifyName() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.patch("/api/person/1")
                        .param("name", "martinModified"))
                .andExpect(status().isOk());

        assertThat(personRepository.findById(1L).get().getName()).isEqualTo("martinModified");
    }

    @Test
    void deletePerson() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.delete("/api/person/1"))
                .andExpect(status().isOk());

        assertTrue(personRepository.findPeopleDeleted().stream().anyMatch(person -> person.getId().equals(1L)));
    }

    private String toJsonString(PersonDto personDto) throws JsonProcessingException {
        return objectMapper.writeValueAsString(personDto);
    }

}