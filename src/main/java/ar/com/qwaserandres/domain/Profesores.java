
package ar.com.qwaserandres.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="teachers")
public class Profesores implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Column(name="id_teachers")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProfesores;
    
    @Column(name="name")
    private String nombre;
    
    @Column(name="last_name")
    private String apellido;
    
    private int DNI;
    
    
}
