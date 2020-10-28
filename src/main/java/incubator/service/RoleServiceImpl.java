package incubator.service;

import incubator.entity.Role;
import incubator.repository.RoleRepos;
import incubator.service.interfaces.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepos roleRepos;

    public Role getById(int id){ return roleRepos.findById(id).get();}
}
