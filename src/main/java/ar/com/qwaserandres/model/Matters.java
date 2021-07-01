package ar.com.qwaserandres.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name="matters")
public class Matters implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Column(name="id_matters")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMaterias;
    
    @NotEmpty
    @Column(name="name")
    private String nombre;
    
    @NotEmpty
    @Column(name="schedule")
    private String horario;
     
    @NotEmpty
    @Column(name="max_numberof_students")
    private int cupoMaxAlumnos;
}
