package ar.com.qwaserandres.dao;

import ar.com.qwaserandres.model.Matters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface I_MattersDAO extends JpaRepository<Matters, Long>{
    
}
