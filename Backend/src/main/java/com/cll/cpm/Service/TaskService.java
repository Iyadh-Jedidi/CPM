package com.cll.cpm.Service;

import com.cll.cpm.Entity.Task;
import com.cll.cpm.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public Task saveTask(Task task ){
        return taskRepository.save(task);
    }

    public Task getTasktById(Long id){
        return taskRepository.findById(id).get();
    }
    public List<Task> getAllTasks (){
        return taskRepository.findAll();
    }
    public void deleteTask (Long id){
        Task task = getTasktById(id);
        if(task == null) {
            System.out.println("Not found");
        }
        taskRepository.delete(task);
    }
}
