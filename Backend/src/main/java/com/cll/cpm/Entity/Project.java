package com.cll.cpm.Entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_generator")
    @SequenceGenerator(name = "project_generator", sequenceName = "project_seq", initialValue = 1, allocationSize = 1)
    private Long idProject;
    private String title;
    private String description;
    private String technologies;

    @OneToMany (mappedBy = "waitingProject")
    private List<User> waitingList;

    @ManyToOne
    private User owner;

    @OneToMany (mappedBy = "project",cascade = CascadeType.REMOVE)
    private List<Task> tasks;

    @ManyToMany
    private List<User> participants;

    public Long getIdProject() {
        return idProject;
    }

    public void setIdProject(Long idProject) {
        this.idProject = idProject;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public List<User> getWaitingList() {
        return waitingList;
    }

    public void setWaitingList(List<User> waitingList) {
        this.waitingList = waitingList;
    }


    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }




    public String getTechnologies() {
        return technologies;
    }

    public void setTechnologies(String technologies) {
        this.technologies = technologies;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public void setParticipants(List<User> participants) {
        this.participants = participants;
    }
}
