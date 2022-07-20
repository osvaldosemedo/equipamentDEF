package cv.pn.equipament.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class SearchEquipmentDTO {


    @JsonProperty("nameEquipment")
    private String nameEquipment;

    @JsonProperty("equipmentType")
    private String equipmentType;

    @JsonProperty("nameEmployee")
    private String nameEmployee;

    @JsonProperty("room")
    private String room;

    @JsonProperty("department")
    private String department;

    @JsonProperty("brand")
    private String brand;

}
