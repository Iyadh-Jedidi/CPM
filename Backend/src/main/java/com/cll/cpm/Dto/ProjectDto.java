package com.cll.cpm.Dto;

import com.cll.cpm.Entity.Task;
import com.cll.cpm.Entity.User;


import java.util.List;

public class ProjectDto {
    private Long idProject;
    private String title;
    private String description;
    private String technologies;

    private List<UserDto> waitingList;
    private UserDto owner;
    private List<TaskDto> tasks;
    private List<UserDto> participants;
}
