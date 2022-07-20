package cv.pn.equipament.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DomainDTO {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    @NotEmpty(message = "Dominio Obrigatorio")
    private String name;

    @JsonProperty("code")
    @NotEmpty(message = "Codigo Obrigatorio")
    private String code;

    @JsonProperty("domain")
    @NotEmpty(message = "Tipo Dominio Obrigatorio")
    private String domain;

    @JsonProperty("order")
    @NotEmpty(message = "Ordem Obrigatorio")
    private String order;

    @JsonProperty("selfId")
    @NotEmpty(message = "SelfId Obrigatorio")
    private String selfId;
}
