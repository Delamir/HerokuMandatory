package dk.kea.herokumandatory.models;

import lombok.Data;
import javax.persistence.*;

@Data
@Table(name = "animals")
@Entity
public class Animal {


    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Id
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private String type;

    @Column
    private int age;
}
