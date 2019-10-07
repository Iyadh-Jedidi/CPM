package com.cll.cpm.Service;

import com.cll.cpm.Entity.Project;
import com.cll.cpm.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveProject(Project project ){
        return projectRepository.save(project);
    }

    public Project getProjectById(Long id){
        return projectRepository.findById(id).get();
    }
    public List<Project> getAllProjects (){
        return projectRepository.findAll();
    }
    public void deleteProject (Long id){
        Project project = getProjectById(id);
        if(project == null) {
            System.out.println("Not found");
        }
        projectRepository.delete(project);
    }
}
