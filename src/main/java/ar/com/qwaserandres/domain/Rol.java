
package ar.com.qwaserandres.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Entity
@Data
@Table(name="role")
public class Rol implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Column(name="id_role")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRol;
    
    @NotEmpty
    @Column(name="name")
    private String nombre; 
}
