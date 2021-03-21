package refactorizando.blog.ejemplogeneral.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import refactorizando.blog.ejemplogeneral.model.UserEntity;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, UUID> {
    List<UserEntity> findByUserNameLike(String userName);
    Boolean deleteByUserName(String userName);
}
