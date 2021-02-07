package kr.co.fastcampus.cli.nullsafe;

import lombok.Data;
import lombok.ToString;
import org.springframework.lang.NonNull;
import org.springframework.lang.NonNullApi;
import org.springframework.lang.NonNullFields;
import org.springframework.stereotype.Component;

@ToString
@Component
public class NonNullBean {
    @NonNull
    private String a = "";

    @NonNull
    public String getA(@NonNull String aa) {
        return aa;
    }
}
