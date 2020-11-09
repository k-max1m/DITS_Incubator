package incubator.repository;

import incubator.entity.Role;
import incubator.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepos extends JpaRepository<User, Integer> {

    User findByLogin(String login);

    List<User> getUserByUserIdNotNull();

    User getByUserId(int id);

    List<User> getAllByRole(Role role);

    @Modifying
    @Query("update User u set u.password = :value where u.userId = :uId")
    void updatePassword(@Param(value = "value") String value,
                    @Param(value = "uId") int userId);

    @Modifying
    @Query("update User u set u.firstName = :value where u.userId = :uId")
    void updateFirstName(@Param(value = "value") String value,
                        @Param(value = "uId") int userId);

    @Modifying
    @Query("update User u set u.lastName = :value where u.userId = :uId")
    void updateLastName(@Param(value = "value") String value,
                         @Param(value = "uId") int userId);

    @Modifying
    @Query("update User u set u.login = :value where u.userId = :uId")
    void updateLogin(@Param(value = "value") String value,
                        @Param(value = "uId") int userId);

    @Modifying
    @Query("update User u set u.role = :value where u.userId = :uId")
    void updateRole(@Param(value = "value") Role value,
                     @Param(value = "uId") int userId);

}
