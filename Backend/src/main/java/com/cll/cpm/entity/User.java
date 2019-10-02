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

    @ManyToMany
    private Project partProject;


    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getCompetences() {
        return competences;
    }

    public void setCompetences(List<String> competences) {
        this.competences = competences;
    }

    public Project getOwnProject() {
        return ownProject;
    }

    public void setOwnProject(Project ownProject) {
        this.ownProject = ownProject;
    }

    public Project getPartProject() {
        return partProject;
    }

    public void setPartProject(Project partProject) {
        this.partProject = partProject;
    }
}
