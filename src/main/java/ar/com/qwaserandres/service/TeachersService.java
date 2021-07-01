package ar.com.qwaserandres.service;

import ar.com.qwaserandres.model.Teachers;
import java.util.List;

public interface TeachersService {

    public List<Teachers> listarProfesores();
    
    public void guardar(Teachers profesor);
    
    public void eliminar(Teachers profesor);
    
    public Teachers encontrarProfesores(Teachers profesor);

}
