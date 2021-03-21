package refactorizando.blog.ejemplogeneral.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import refactorizando.blog.ejemplogeneral.constants.JacksonFieldName;

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
    private UUID id;
    private String userName;
    private String firstName;
    private BigDecimal balance;
    private Instant createdOn;

}
