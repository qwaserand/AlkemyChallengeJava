package ar.com.qwaserandres.service;

import ar.com.qwaserandres.dao.I_TeachersDAO;
import ar.com.qwaserandres.model.Teachers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TeachersServiceImpl implements TeachersService {

    @Autowired 
    private I_TeachersDAO profesoresDAO;
    
    @Override
    @Transactional(readOnly = true)
    public List<Teachers> listarProfesores() {
        return (List<Teachers>) profesoresDAO.findAll();
    }

    @Override
    @Transactional
    public void guardar(Teachers profesor) {
        profesoresDAO.save(profesor);
    }

    @Override
    public void eliminar(Teachers profesor) {
        profesoresDAO.delete(profesor);
    }

    @Override
    public Teachers encontrarProfesores(Teachers profesor) {
        return profesoresDAO.findById(profesor.getIdProfesores()).orElse(null);
    }
    
}
