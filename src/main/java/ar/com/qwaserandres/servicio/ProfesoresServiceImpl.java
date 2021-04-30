
package ar.com.qwaserandres.servicio;

import ar.com.qwaserandres.dao.I_ProfesoresDAO;
import ar.com.qwaserandres.domain.Profesores;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProfesoresServiceImpl implements ProfesoresService {

    @Autowired 
    private I_ProfesoresDAO profesoresDAO;
    
    @Override
    @Transactional(readOnly = true)
    public List<Profesores> listarProfesores() {
        return (List<Profesores>) profesoresDAO.findAll();
    }

    @Override
    @Transactional
    public void guardar(Profesores profesor) {
        profesoresDAO.save(profesor);
    }

    @Override
    public void eliminar(Profesores profesor) {
        profesoresDAO.delete(profesor);
    }

    @Override
    public Profesores encontrarProfesores(Profesores profesor) {
        return profesoresDAO.findById(profesor.getIdProfesores()).orElse(null);
    }
    
}
