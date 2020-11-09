package incubator.service.interfaces;

import incubator.entity.User;

import java.util.List;

public interface UserService {
    public User getById(int id);

    public List<User> getAll();

    User findByLogin(String login);

    void deleteUserById(int id);

    boolean save(User user);

    void updatePassword(User user);

    void updateFirstName(User user);

    void updateLastName(User user);

    void updateLogin(User user);

    void updateRole(User user);
}
