package refactorizando.blog.ejemplogeneral.service;

import org.springframework.http.ResponseEntity;
import refactorizando.blog.ejemplogeneral.dto.SimpleResponse;
import refactorizando.blog.ejemplogeneral.dto.user.UserDTO;
import refactorizando.blog.ejemplogeneral.exception.user.FailedToCreateOrUpdateUser;
import refactorizando.blog.ejemplogeneral.exception.user.UserNotFoundException;
import refactorizando.blog.ejemplogeneral.model.UserEntity;

import java.util.List;
import java.util.UUID;

public interface UserService {
    ResponseEntity<SimpleResponse> saveUser(UserDTO user) throws FailedToCreateOrUpdateUser;
    ResponseEntity<SimpleResponse> deleteUser(UUID id) throws UserNotFoundException;
    ResponseEntity<UserEntity> findById(UUID id) throws UserNotFoundException;
    ResponseEntity<List<UserEntity>>findByNameLike(String Username) throws UserNotFoundException;
    ResponseEntity<SimpleResponse>updateUser(UserDTO user) throws FailedToCreateOrUpdateUser;

}
