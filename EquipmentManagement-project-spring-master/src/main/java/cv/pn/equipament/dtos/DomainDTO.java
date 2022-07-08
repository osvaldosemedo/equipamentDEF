package cv.pn.equipament.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DomainDTO {
    private String id;
    private String name;
    private String code;
    private String domain;
    private String order;
    private String selfId;
}
