
package ar.com.qwaserandres.dao;

import ar.com.qwaserandres.domain.Profesores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface I_ProfesoresDAO extends JpaRepository<Profesores, Long> {

}
