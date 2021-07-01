package ar.com.qwaserandres.service;

import ar.com.qwaserandres.dao.I_UserDAO;
import ar.com.qwaserandres.model.Role;
import ar.com.qwaserandres.model.User;
import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
@Slf4j
public class UserService implements UserDetailsService{

    @Autowired
    private I_UserDAO usuarioDAO;
    
    @Override
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = usuarioDAO.findByUsername(username);
        
        if(user == null) {
            throw new UsernameNotFoundException(username);
        }
        
        var roles = new ArrayList<GrantedAuthority>(); 
        
        for(Role role : user.getRoles()) {
            roles.add(new SimpleGrantedAuthority(role.getNombre()));
        }
        
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(), roles);
    }
    
}
