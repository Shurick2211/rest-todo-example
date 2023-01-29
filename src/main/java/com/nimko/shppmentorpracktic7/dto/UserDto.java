package com.nimko.shppmentorpracktic7.dto;

import com.nimko.shppmentorpracktic7.utils.Role;
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String name;
    @NonNull
    private String login;
    @NonNull
    private String password;
    @NonNull
    private Role role;
}
