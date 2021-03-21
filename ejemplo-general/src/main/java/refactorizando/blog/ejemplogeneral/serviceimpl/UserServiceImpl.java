package refactorizando.blog.ejemplogeneral.serviceimpl;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import refactorizando.blog.ejemplogeneral.constants.Messages;
import refactorizando.blog.ejemplogeneral.dto.SimpleResponse;
import refactorizando.blog.ejemplogeneral.dto.user.UserDTO;
import refactorizando.blog.ejemplogeneral.exception.user.FailedToCreateOrUpdateUser;
import refactorizando.blog.ejemplogeneral.exception.user.UserNotFoundException;
import refactorizando.blog.ejemplogeneral.model.UserEntity;
import refactorizando.blog.ejemplogeneral.repository.UserRepository;
import refactorizando.blog.ejemplogeneral.service.UserService;
import refactorizando.blog.ejemplogeneral.utils.UserUtils;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor(onConstructor =@__({@Autowired}))
@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;


    @Override
    public ResponseEntity<SimpleResponse> saveUser(UserDTO user) throws FailedToCreateOrUpdateUser {
        UserEntity userEntity= UserUtils.mapUserDTOtoUser(user);
        userEntity=UserUtils.createInstant(userEntity);
        userEntity=userRepository.save(userEntity);
        if(UserUtils.isUserNull(userEntity))
            throw new FailedToCreateOrUpdateUser();
        SimpleResponse response=new SimpleResponse();
        response.setMessage(Messages.USER_CREATED_SUCCESSFULLY);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<SimpleResponse> deleteUser(UUID id) throws UserNotFoundException {
        userRepository.deleteById(id);
        Optional<UserEntity> userEntity=userRepository.findById(id);
        if (!userEntity.isEmpty())
            throw new UserNotFoundException();
        SimpleResponse response=new SimpleResponse();
        response.setMessage(Messages.USER_DELETED_SUCCESSFULLY);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserEntity> findById(UUID id) throws UserNotFoundException {
        Optional<UserEntity> userEntity=userRepository.findById(id);
        if (userEntity.isEmpty())
            throw new UserNotFoundException();
        return new ResponseEntity<>(userEntity.get(),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<UserEntity>> findByNameLike(String Username) throws UserNotFoundException {
        List<UserEntity> userEntity=userRepository.findByUserNameLike(Username);
        if (userEntity.isEmpty())
            throw new UserNotFoundException();
        return new ResponseEntity<List<UserEntity>>(userEntity,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<SimpleResponse> updateUser(UserDTO user) throws FailedToCreateOrUpdateUser {
        UserEntity userEntity=UserUtils.mapUserDTOtoUser(user);
        userEntity=userRepository.save(userEntity);
        if(UserUtils.isUserNull(userEntity))
            throw new FailedToCreateOrUpdateUser();
        SimpleResponse response=new SimpleResponse();
        response.setMessage(Messages.USER_UPDATED_SUCCESSFULLY);
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }


}
