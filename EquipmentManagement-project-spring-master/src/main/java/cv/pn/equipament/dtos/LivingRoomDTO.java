package cv.pn.equipament.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LivingRoomDTO {
    private String id;
    private  String name;
    private String number;
    private String dmPiso;
    private String dmDivision;
    private String contactPhone;

}
