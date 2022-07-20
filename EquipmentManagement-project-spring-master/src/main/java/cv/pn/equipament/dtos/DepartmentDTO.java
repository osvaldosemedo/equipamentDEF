package cv.pn.equipament.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DepartmentDTO {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    @NotEmpty(message = "Departamento Obrigatorio")
    private String name;

    @JsonProperty("code")
    private String code;

    @JsonProperty("selfId")
    @NotEmpty(message = " SelfId Obrigatorio")
    private String selfId;

    @JsonProperty("userCreated")
    @NotEmpty(message = "Utilizador Obrigatorio")
    private String userCreated;


}
