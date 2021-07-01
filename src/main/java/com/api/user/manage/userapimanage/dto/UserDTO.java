package com.api.user.manage.userapimanage.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long id;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String name;

    private Date birthdate;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String email;

    @NotEmpty
    @Size(min = 2, max = 15)
    private String password;
}
