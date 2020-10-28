package incubator.service;

import incubator.entity.Role;
import incubator.repository.RoleRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private RoleRepos roleRepos;

    public Role getById(int id){ return roleRepos.findById(id).get();}
}
