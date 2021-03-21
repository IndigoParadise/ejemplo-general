package refactorizando.blog.ejemplogeneral.utils;


import com.fasterxml.jackson.databind.ObjectMapper;
import refactorizando.blog.ejemplogeneral.dto.user.UserDTO;
import refactorizando.blog.ejemplogeneral.model.UserEntity;

import java.time.Instant;
import java.util.UUID;

public class UserUtils {
    public static UserEntity mapUserDTOtoUser(UserDTO userDTO){
        ObjectMapper mapper=new ObjectMapper();
        return mapper.convertValue(userDTO, UserEntity.class);
    }
    public static UUID generateRandomUUID(){
        return UUID.randomUUID();
    }

    public static Boolean isUserNull(UserEntity userEntity){
        return userEntity==null;
    }
    public static UserEntity createInstant(UserEntity userEntity){
         userEntity.setCreatedOn(Instant.now());
         return userEntity;
    }


}
