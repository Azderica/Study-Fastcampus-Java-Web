package kr.co.fastcampus.cli.nullsafe;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class Person2 {
    @NonNull
    private String fullName;
    @Nullable
    private String nickName;

    public void setFullName(String fullName) {
        if (fullName != null && fullName.isEmpty()) {
            fullName = null;
        }
        this.fullName = fullName;
    }

    public void setNickName(String nickName) {
        if (nickName != null && nickName.isEmpty()) {
            nickName = null;
        }
        this.nickName = nickName;
    }

    String getFullName() {
        return fullName;
    }

    String getNickName() {
        return nickName;
    }
}
