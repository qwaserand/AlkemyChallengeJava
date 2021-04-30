
package ar.com.qwaserandres.dao;

import ar.com.qwaserandres.domain.Materias;
import org.springframework.data.jpa.repository.JpaRepository;

public interface I_MateriasDAO extends JpaRepository<Materias, Long>{
    
}
