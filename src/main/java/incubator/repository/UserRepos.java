package incubator.repository;

import incubator.entity.Role;
import incubator.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;

@Repository
public interface UserRepos extends JpaRepository<User,Integer> {

    User findByLogin(String login);

}
