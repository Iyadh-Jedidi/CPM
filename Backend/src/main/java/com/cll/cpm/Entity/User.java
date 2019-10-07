package com.cll.cpm.Entity;

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
    private String competences;

    @OneToMany (mappedBy = "owner")
    private List<Project> ownProjects;

    @ManyToMany (mappedBy = "participants",cascade = CascadeType.REMOVE)
    private List<Project> projects;
    @ManyToMany
    private List <Project> waitingProject;


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





    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }




    public List<Project> getWaitingProject() {
        return waitingProject;
    }

    public void setWaitingProject(List<Project> waitingProject) {
        this.waitingProject = waitingProject;
    }

    public List<Project> getOwnProjects() {
        return ownProjects;
    }

    public void setOwnProjects(List<Project> ownProjects) {
        this.ownProjects = ownProjects;
    }

    public String getCompetences() {
        return competences;
    }

    public void setCompetences(String competences) {
        this.competences = competences;
    }
}