package ar.com.qwaserandres.dao;

import ar.com.qwaserandres.model.Teachers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface I_TeachersDAO extends JpaRepository<Teachers, Long> {

}
