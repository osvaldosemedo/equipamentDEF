package cv.pn.equipament.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "employee")
public class Employee extends CommonsAttributes {

    @Column(name = "name", nullable = true, columnDefinition = "character varying(100)")
    private String name;

    @Column(name = "function", nullable = true, columnDefinition = "character varying(40)")
    private String function;

    @Column(name = "patent", nullable = true, columnDefinition = "character varying(100)")
    private String patent;

    @Column(name = "dm_type_user", nullable = true, columnDefinition = "character varying(40)")
    private String DmTypeUser;

    @ManyToOne
    @JoinColumn(name = "id_livinRoom",  referencedColumnName = "id",  updatable=false)
    @JsonBackReference
    private  LivingRoom livinRoom;




}
