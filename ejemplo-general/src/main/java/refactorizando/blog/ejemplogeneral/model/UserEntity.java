package refactorizando.blog.ejemplogeneral.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import refactorizando.blog.ejemplogeneral.constants.Constants;
import refactorizando.blog.ejemplogeneral.constants.JacksonFieldName;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name=JacksonFieldName.TABLE_NAME_USER)
public class UserEntity {

    @Id
    @Column(name = Constants.ID)
    private UUID id;
    @Column(name = Constants.USER_NAME)
    private String userName;
    @Column(name = Constants.FIRST_NAME)
    private String firstName;
    @Column(name = Constants.BALANCE)
    private BigDecimal balance;
    @Column(name = Constants.CREATED_ON)
    private Instant createdOn;

}
