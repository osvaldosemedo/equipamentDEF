package cv.pn.equipament.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class ResponseSearchEquipmentDTO {

    @JsonProperty("id")
    private String id;

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

}
