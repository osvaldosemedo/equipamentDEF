package cv.pn.equipament.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EquipmentDTO {
    private String id;

    @JsonProperty("name")
    @NotEmpty(message = "Nome Equipamento Obrigatorio")
    private String name;

    @JsonProperty("brand")
    @NotEmpty(message = "Marca Obrigatorio")
    private String brand;

    private String model;
    private String serialNumber;
    private String processor;

    @JsonProperty("rom")
    @NotEmpty(message = "Rom Obrigatorio")
    private String rom;

    @JsonProperty("ram")
    private String ram;

    @JsonProperty("generation")
    private String generation;

    @JsonProperty("velocity")
    private  String velocity;

    @JsonProperty("systemType")
    private  String systemType;

    @JsonProperty("dmStateEquip")
    @NotEmpty(message = "Estado Equipamento Obrigatorio")
    private String dmStateEquip;

    @JsonProperty("screen")
    private  String screen;

    @JsonProperty("obs")
    private String obs;

    @JsonProperty("idEquipmentType")
    @NotEmpty(message = "Tipo Equipamento Obrigatorio")
    private String idEquipmentType;

    @JsonProperty("idLivingRoom")
    @NotEmpty(message = "Sala Obrigatorio")
    private String idLivingRoom;

    @JsonProperty("idEmployee")
    private String idEmployee;


}
