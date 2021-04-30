
package ar.com.qwaserandres.servicio;

import ar.com.qwaserandres.domain.Materias;
import java.util.List;

public interface MateriasService {

    public List<Materias> listarMaterias();
    
    public void guardar(Materias materia);
    
    public void eliminar(Materias materia);
    
    public Materias encontrarMaterias(Materias materia);
}
