package cv.pn.equipament.dtos;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeDTO {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    @NotEmpty(message = "Nome Utilizador Obrigatorio")
    private String name;

    @JsonProperty("function")
    private String function;

    @JsonProperty("patent")
    private String patent;

    @JsonProperty("email")
    private String email;

    @JsonProperty("dmTypeUser")
    @NotEmpty(message = "Tipo Utilizador Obrigatorio")
    private String dmTypeUser;

    @JsonProperty("idLivingRoom")
    @NotEmpty(message = "Sala Obrigatorio")
    private String idLivingRoom;

}
