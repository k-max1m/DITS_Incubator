package incubator.repository;

import incubator.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepos extends JpaRepository<Role, Integer> {
    Role getByRoleId(int id);

    List<Role> getAllByAdmin(int binary);

    List<Role> getAllByTutor(int binary);

    List<Role> getAllByUser(int binary);
}
