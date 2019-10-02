package com.cll.cpm.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
    @SequenceGenerator(name = "user_generator", sequenceName = "user_seq", initialValue = 1, allocationSize = 1)
    private Long idUser;
    private String name ;
    private String lastname;
    private String email;
    private String password;
    private List<String> competences;

    @OneToOne (mappedBy = "owner")
    private Project ownProject;
    @OneToMany


    @OneToMany
    private List <Project> makeProject ;
    @OneToMany
    private List <Project> participateProject;


}
