package cv.pn.equipament.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailEquipmentDTO {
    private EquipmentDTO equipment;
    private EmployeeDTO employee;
    private EquipmentTypeDTO equipmentType;
    private LivingRoomDTO livingRoom;
    private DepartmentDTO department;

}
