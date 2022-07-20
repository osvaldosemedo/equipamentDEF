package cv.pn.equipament.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailEquipmentDTO {

    @JsonProperty("equipment")
    private EquipmentDTO equipment;

    @JsonProperty("employee")
    private EmployeeDTO employee;

    @JsonProperty("equipmentType")
    private EquipmentTypeDTO equipmentType;

    @JsonProperty("livingRoom")
    private LivingRoomDTO livingRoom;

    @JsonProperty("department")
    private DepartmentDTO department;

}
