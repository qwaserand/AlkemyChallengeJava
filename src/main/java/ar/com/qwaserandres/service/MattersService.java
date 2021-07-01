package ar.com.qwaserandres.service;

import ar.com.qwaserandres.model.Matters;
import java.util.List;

public interface MattersService {

    public List<Matters> listarMaterias();
    
    public void guardar(Matters materia);
    
    public void eliminar(Matters materia);
    
    public Matters encontrarMaterias(Matters materia);
}
