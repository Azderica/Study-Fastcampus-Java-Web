package com.myepark.project.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable
@Data
@NoArgsConstructor
public class Birthday {
    private Integer yearOfBirthday;
    private Integer monthOfBirthday;
    private Integer dayOfBirthday;

    public Birthday(LocalDate birthday){
        this.yearOfBirthday = birthday.getYear();
        this.monthOfBirthday = birthday.getMonthValue();
        this.dayOfBirthday = birthday.getDayOfMonth();
    }
//
//    public int getAge() {
//        return LocalDate.now().getYear() - this.yearOfBirthday + 1;
//    }
//
//    public boolean isBirthdayToday() {
//        return LocalDate.now().equals(LocalDate.of(yearOfBirthday, monthOfBirthday, dayOfBirthday));
//    }

    public static Birthday of(LocalDate birthday) {
        return new Birthday(birthday);
    }
}
