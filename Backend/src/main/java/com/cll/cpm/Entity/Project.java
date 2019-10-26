package com.cll.cpm.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_generator")
    @SequenceGenerator(name = "project_generator", sequenceName = "project_seq", initialValue = 1, allocationSize = 1)
    private Long idProject;
    private String title;
    private String description;
    private String technologies;
    private Date dateDebut;
    private Date dateLivraison;

    @OneToMany (mappedBy = "waitingProject")
    private List<User> waitingList;

    @ManyToOne
    private User owner;

    @OneToMany (mappedBy = "project",cascade = CascadeType.REMOVE)
    private List<Task> tasks;

    @ManyToMany
    private List<User> participants;

}
