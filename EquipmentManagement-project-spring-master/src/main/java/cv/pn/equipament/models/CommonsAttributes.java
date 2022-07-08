package cv.pn.equipament.models;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
public class CommonsAttributes {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", nullable = false, columnDefinition = "character varying(40) default uuid_generate_v1()")
    private String id;

    @Column(name = "date_created", nullable = true, columnDefinition = "timestamp DEFAULT now()")
    @CreationTimestamp
    private LocalDateTime dateCreated;


    @Column(name = "date_updated", nullable = true, columnDefinition = "timestamp DEFAULT now()")
    @UpdateTimestamp
    private LocalDateTime dateUpdated;


    @Column(name = "user_created", nullable = true, columnDefinition = "character varying(40)")
    private String userCreated;

    @Column(name = "user_updated", nullable = true, columnDefinition = "character varying(40)")
    private String userUpdated;





}
