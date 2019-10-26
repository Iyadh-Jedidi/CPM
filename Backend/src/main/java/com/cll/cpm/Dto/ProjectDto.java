package com.cll.cpm.Dto;

import com.cll.cpm.Entity.Task;
import com.cll.cpm.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Date;
import java.util.List;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto {
    private Long idProject;
    private String title;
    private String description;
    private String technologies;
    private List<UserDto> waitingList;
    private UserDto owner;
    private List<TaskDto> tasks;
    private List<UserDto> participants;
    private Date dateDebut;
    private Date dateLivraison;
}
