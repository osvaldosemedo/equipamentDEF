package cv.pn.equipament.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EquipmentTypeDTO {
    private  String id;

    @JsonProperty("name")
    @NotEmpty(message = "Tipo Equipamento Obrigatorio")
    private String name;

    @JsonProperty("code")
    @NotEmpty(message = "Codigo Obrigatorio")
    private String code;

    @JsonProperty("selfId")
    @NotEmpty(message = "SelfId Obrigatorio")
    private String selfId;



}
