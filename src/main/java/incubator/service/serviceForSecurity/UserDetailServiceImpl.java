package incubator.service.serviceForSecurity;

import incubator.entity.Role;
import incubator.entity.User;
import incubator.repository.RoleRepos;
import incubator.repository.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @PersistenceContext
    private EntityManager em;
    @Autowired
    private UserRepos userRepos;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private RoleRepos roleRepos;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepos.findByLogin(login);
        if(user == null){
            throw new UsernameNotFoundException("User not found");
        }
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        Role role = user.getRole();
        if (role.getTutor() == '1' && role.getAdmin() == '1' && role.getUser() == '1') {
            grantedAuthorities.add(new GrantedAuthorityImpl("TUTOR"));
            grantedAuthorities.add(new GrantedAuthorityImpl("ADMIN"));
            grantedAuthorities.add(new GrantedAuthorityImpl("USER"));
        } else if (role.getTutor() == '1' && role.getAdmin() == '1') {
            grantedAuthorities.add(new GrantedAuthorityImpl("TUTOR"));
            grantedAuthorities.add(new GrantedAuthorityImpl("ADMIN"));
        } else  if (role.getUser() == '1' && role.getTutor() == '1') {
            grantedAuthorities.add(new GrantedAuthorityImpl("TUTOR"));
            grantedAuthorities.add(new GrantedAuthorityImpl("USER"));
        } else if (role.getUser() == '1' && role.getAdmin() == '1') {
            grantedAuthorities.add(new GrantedAuthorityImpl("USER"));
            grantedAuthorities.add(new GrantedAuthorityImpl("ADMIN"));
        } else if(role.getUser() == '1'){
            grantedAuthorities.add(new GrantedAuthorityImpl("USER"));
        } else if(role.getAdmin() == '1'){
            grantedAuthorities.add(new GrantedAuthorityImpl("ADMIN"));
        } else if(role.getTutor() == '1'){
            grantedAuthorities.add(new GrantedAuthorityImpl("TUTOR"));
        }


        return new org.springframework.security.core.userdetails.User(user.getLogin(),user.getPassword(),grantedAuthorities);
    }

    public boolean save(User user){
        User aUser = userRepos.findByLogin(user.getLogin());
        if(aUser != null){
            return false;
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepos.save(user);
        return true;
    }
}
