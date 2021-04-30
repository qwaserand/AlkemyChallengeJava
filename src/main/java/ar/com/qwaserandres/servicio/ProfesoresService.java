
package ar.com.qwaserandres.servicio;

import ar.com.qwaserandres.domain.Profesores;
import java.util.List;

public interface ProfesoresService {

    public List<Profesores> listarProfesores();
    
    public void guardar(Profesores profesor);
    
    public void eliminar(Profesores profesor);
    
    public Profesores encontrarProfesores(Profesores profesor);
}
