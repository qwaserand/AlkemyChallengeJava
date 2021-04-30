
package ar.com.qwaserandres.dao;

import ar.com.qwaserandres.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface I_UsuarioDAO extends JpaRepository<Usuario, Long> {
    Usuario findByUsername(String username);
}
