package refactorizando.blog.ejemplogeneral.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import refactorizando.blog.ejemplogeneral.constants.JacksonFieldName;

import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    @JsonProperty(value = JacksonFieldName.ID,required = false)
    private UUID id;
    @JsonProperty(value=JacksonFieldName.USER_NAME,required = true)
    private String userName;
    @JsonProperty(value = JacksonFieldName.FIRST_NAME,required = true)
    private String firstName;
    @JsonProperty(value = JacksonFieldName.BALANCE,required = true)
    private BigDecimal balance;
}
