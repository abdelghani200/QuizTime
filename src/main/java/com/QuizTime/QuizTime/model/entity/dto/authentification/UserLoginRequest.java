package com.QuizTime.QuizTime.model.entity.dto.authentification;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserLoginRequest {
    private String username;
    private String password;
}
