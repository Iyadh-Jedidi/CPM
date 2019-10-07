package com.cll.cpm.Controller;

import com.cll.cpm.Dto.UserDto;
import com.cll.cpm.Entity.User;
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
public class UserController {
    @Autowired
    private UserService userService ;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/users")
    public Object getAllUsers (){
        List<User> users = userService.getAllUsers();
        Type listType = new TypeToken<List<UserDto>>(){}.getType();
        List <UserDto> userDtos = modelMapper.map(users,listType);
        return ResponseEntity.status(HttpStatus.OK).body(userDtos);
    }
    @GetMapping("/users/{{id}}")
    public Object getUserById (@PathVariable Long id){
        User user = userService.getUserById(id);
        UserDto userDto = modelMapper.map(user,UserDto.class);
        return ResponseEntity.status(HttpStatus.OK).body(userDto);
    }
    @PostMapping("/users")
    public Object addUser (@Valid @RequestBody UserDto userDto){
        User user = modelMapper.map(userDto,User.class);
        user = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.OK).body(userDto);
    }
    @PutMapping("/users/{id}")
    public Object updateUser(@Valid @RequestBody UserDto userDto, @PathVariable long id) {

        User user = modelMapper.map(userDto, User.class);
        user.setIdUser(id);

        user = userService.saveUser(user);

        userDto = modelMapper.map(user, UserDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(userDto);
    }
    @DeleteMapping("/users/{id}")
    public Object DeleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
