package cv.pn.equipament.dtos;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LivingRoomDTO {
    private String id;

    @JsonProperty("name")
    @NotEmpty(message = "sala Obrigatorio")
    private  String name;

    @JsonProperty("number")
    private String number;

    @JsonProperty("dmPiso")
    @NotEmpty(message = "Piso Obrigatorio")
    private String dmPiso;

    @JsonProperty("contactPhone")
    private String contactPhone;

    @JsonProperty("idDepartment")
    @NotEmpty(message = "Departamento Obrigatorio")
    private String idDepartment;

}
