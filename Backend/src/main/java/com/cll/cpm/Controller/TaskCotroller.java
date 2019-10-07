package com.cll.cpm.Controller;

import com.cll.cpm.Dto.TaskDto;
import com.cll.cpm.Dto.UserDto;
import com.cll.cpm.Entity.Task;
import com.cll.cpm.Entity.User;
import com.cll.cpm.Service.TaskService;
import com.cll.cpm.Service.UserService;
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
public class TaskCotroller {
    @Autowired
    private TaskService taskService ;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/tasks")
    public Object getAllTasks (){
        List<Task> tasks = taskService.getAllTasks();
        Type listType = new TypeToken<List<UserDto>>(){}.getType();
        List <TaskDto> taskDtos = modelMapper.map(tasks,listType);
        return ResponseEntity.status(HttpStatus.OK).body(taskDtos);
    }
    @GetMapping("/tasks/{{id}}")
    public Object getTaskById (@PathVariable Long id){
        Task task = taskService.getTasktById(id);
        TaskDto taskDto = modelMapper.map(task,TaskDto.class);
        return ResponseEntity.status(HttpStatus.OK).body(taskDto);
    }
    @PostMapping("/tasks")
    public Object addTask (@Valid @RequestBody TaskDto taskDto){
        Task task = modelMapper.map(taskDto,Task.class);
        task = taskService.saveTask(task);
        return ResponseEntity.status(HttpStatus.OK).body(taskDto);
    }
    @PutMapping("/tasks/{id}")
    public Object updateTask(@Valid @RequestBody TaskDto taskDto, @PathVariable long id) {

        Task task = modelMapper.map(taskDto, Task.class);
        task.setIdTache(id);

        task = taskService.saveTask(task);

        taskDto = modelMapper.map(task, TaskDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(taskDto);
    }
    @DeleteMapping("/tasks/{id}")
    public Object DeleteTask(@PathVariable("id") Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
