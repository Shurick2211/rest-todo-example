package com.nimko.shppmentorpracktic7.dto;

import com.nimko.shppmentorpracktic7.utils.Role;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "Схема USER", description = "DTO User для фронтенду!")
public class UserDto {
    private String name;
    @NonNull
    private String login;
    @NonNull
    private String password;
    @NonNull
    private Role role;
}
