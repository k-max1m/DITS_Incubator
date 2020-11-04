package incubator.repository;

import incubator.entity.Role;
import incubator.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepos extends JpaRepository<User, Integer> {

    User findByLogin(String login);

    List<User> getUserByUserIdNotNull();

    User getByUserId(int id);

    List<User> getAllByRole(Role role);

}
