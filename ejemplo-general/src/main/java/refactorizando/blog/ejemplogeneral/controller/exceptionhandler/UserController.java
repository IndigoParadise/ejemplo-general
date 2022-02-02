package refactorizando.blog.ejemplogeneral.controller.exceptionhandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import refactorizando.blog.ejemplogeneral.model.UserEntity;
import refactorizando.blog.ejemplogeneral.service.UserService;

import java.util.UUID;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    public UserEntity getUser(@PathVariable("iu")UUID id){
        return userService.findById(id).getBody();
    }
}
