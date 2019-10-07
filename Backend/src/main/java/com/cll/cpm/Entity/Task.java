package com.cll.cpm.Entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tache_generator")
    @SequenceGenerator(name = "tache_generator", sequenceName = "tache_seq", initialValue = 1, allocationSize = 1)
    private Long idTache;
    private String title;
    private String description;

    @ManyToOne
    private Project project ;

    public Long getIdTache() {
        return idTache;
    }

    public void setIdTache(Long idTache) {
        this.idTache = idTache;
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

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
