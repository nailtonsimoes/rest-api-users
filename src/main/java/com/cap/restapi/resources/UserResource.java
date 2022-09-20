package com.cap.restapi.resources;

import com.cap.restapi.Repositorys.UserRepository;
import com.cap.restapi.models.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API Rest")
@CrossOrigin(origins = "*")
public class UserResource {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    @ApiOperation(value = "Retorna uma lista com todos Usuarios")
    public List<User> listUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    @ApiOperation(value = "Retorna um Usuario")
    public User listOneUser(@PathVariable(value="id") long id){
        return userRepository.findById(id);
    }

    @PostMapping("/user")
    @ApiOperation(value = "Cria um novo Usuario")
    public User saveUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @DeleteMapping("/user")
    @ApiOperation(value = "Remove um Usuario")
    public void deleteUser(@RequestBody User user) {
        userRepository.delete(user);
    }

    @PutMapping("/user")
    @ApiOperation(value = "Atualiza um Usuario")
    public User updateUser(@RequestBody User user) {
        return userRepository.save(user);
    }


}
