package com.cll.cpm.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
    @SequenceGenerator(name = "user_generator", sequenceName = "user_seq", initialValue = 1, allocationSize = 1)
    private Long idUser;
    private String name ;
    private String lastname;
    private String email;
    private String password;
    private String competences;

    @OneToMany (mappedBy = "owner")
    private List<Project> ownProjects;

    @ManyToMany (mappedBy = "participants",cascade = CascadeType.REMOVE)
    private List<Project> projects;
    @ManyToMany
    private List <Project> waitingProject;


}
