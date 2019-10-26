package com.cll.cpm.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long idUser;
    private String name;
    private String lastname;
    private String email;
    private String password;
    private String competences;

}
