package cv.pn.equipament.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeDTO {
    private String id;
    private String name;
    private String function;
    private String patent;
    private String dmTypeUser;
    private String idLivingRoom;

}
