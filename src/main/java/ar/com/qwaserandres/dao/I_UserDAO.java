package ar.com.qwaserandres.dao;

import ar.com.qwaserandres.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface I_UserDAO extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
