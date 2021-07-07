package com.api.user.manage.userapimanage.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {

    private Long id;

    @NotNull
    @Size(min = 2, max = 100)
    private String email;

    @NotNull
    @Size(min = 2, max = 50)
    private String password;
}
