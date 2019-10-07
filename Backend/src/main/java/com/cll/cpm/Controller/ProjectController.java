package com.cll.cpm.Controller;

import com.cll.cpm.Dto.ProjectDto;
import com.cll.cpm.Entity.Project;
import com.cll.cpm.Service.ProjectService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Type;
import java.util.List;

@CrossOrigin("*")
@RestController()
public class ProjectController {
    @Autowired
    private ProjectService projectService ;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/projects")
    public Object getAllProjects (){
        List<Project> projets = projectService.getAllProjects();
        Type listType = new TypeToken<List<ProjectDto>>(){}.getType();
        List <ProjectDto> projetsDto = modelMapper.map(projets,listType);
        return ResponseEntity.status(HttpStatus.OK).body(projetsDto);
    }
    @GetMapping("/projects/{{id}}")
    public Object getProjectById (@PathVariable Long id){
        Project project = projectService.getProjectById(id);
        ProjectDto projectDto = modelMapper.map(project,ProjectDto.class);
        return ResponseEntity.status(HttpStatus.OK).body(projectDto);
    }
    @PostMapping("/projects")
    public Object addProject (@Valid @RequestBody ProjectDto projectDto){
        Project project = modelMapper.map(projectDto,Project.class);
        project = projectService.saveProject(project);
        return ResponseEntity.status(HttpStatus.OK).body(projectDto);
    }
    @PutMapping("/projects/{id}")
    public Object updateProject(@Valid @RequestBody ProjectDto projectDto, @PathVariable long id) {

        Project project = modelMapper.map(projectDto, Project.class);
        project.setIdProject(id);

        project = projectService.saveProject(project);

        projectDto = modelMapper.map(project, ProjectDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(projectDto);
    }
    @DeleteMapping("/projects/{id}")
    public Object DeleteProject(@PathVariable("id") Long id) {
        projectService.deleteProject(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
