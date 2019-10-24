package com.cll.cpm.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tache_generator")
    @SequenceGenerator(name = "tache_generator", sequenceName = "tache_seq", initialValue = 1, allocationSize = 1)
    private Long idTache;
    private String title;
    private String description;

    @ManyToOne
    private Project project ;

}
