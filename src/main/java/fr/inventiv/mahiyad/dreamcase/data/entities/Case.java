package fr.inventiv.mahiyad.dreamcase.data.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cases")
@Data @AllArgsConstructor @NoArgsConstructor
public class Case {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    @Column(length = 2056)
    private String description;
    @Column(name = "creation_date")
    private Date creationDate;
    @Column(name = "last_update_date")
    private Date lastUpdateDate;
}
