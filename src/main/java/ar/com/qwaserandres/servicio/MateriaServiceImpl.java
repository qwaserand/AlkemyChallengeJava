
package ar.com.qwaserandres.servicio;

import ar.com.qwaserandres.dao.I_MateriasDAO;
import ar.com.qwaserandres.domain.Materias;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MateriaServiceImpl implements MateriasService {
    
    @Autowired
    private I_MateriasDAO materiasDAO; 
    
    @Override
    @Transactional(readOnly = true)
    public List<Materias> listarMaterias() {
        return (List<Materias>) materiasDAO.findAll(); 
    }

    @Override
    @Transactional
    public void guardar(Materias materia) {
        materiasDAO.save(materia);
    }

    @Override
    @Transactional
    public void eliminar(Materias materia) {
        materiasDAO.delete(materia);
    }

    @Override
    @Transactional(readOnly = true)
    public Materias encontrarMaterias(Materias materia) {
        return materiasDAO.findById(materia.getIdMaterias()).orElse(null); 
    }
}
