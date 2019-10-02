package com.cll.cpm.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Tache {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tache_generator")
    @SequenceGenerator(name = "tache_generator", sequenceName = "tache_seq", initialValue = 1, allocationSize = 1)
    private Long idTache;
    private String title;
    private String description;

    @ManyToMany
    private List<User> affectes ;

}
