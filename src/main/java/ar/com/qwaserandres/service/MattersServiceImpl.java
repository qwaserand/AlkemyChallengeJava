package ar.com.qwaserandres.service;

import ar.com.qwaserandres.dao.I_MattersDAO;
import ar.com.qwaserandres.model.Matters;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MattersServiceImpl implements MattersService {
    
    @Autowired
    private I_MattersDAO materiasDAO;
    
    @Override
    @Transactional(readOnly = true)
    public List<Matters> listarMaterias() {
        return (List<Matters>) materiasDAO.findAll();
    }

    @Override
    @Transactional
    public void guardar(Matters materia) {
        materiasDAO.save(materia);
    }

    @Override
    @Transactional
    public void eliminar(Matters materia) {
        materiasDAO.delete(materia);
    }

    @Override
    @Transactional(readOnly = true)
    public Matters encontrarMaterias(Matters materia) {
        return materiasDAO.findById(materia.getIdMaterias()).orElse(null); 
    }

}
