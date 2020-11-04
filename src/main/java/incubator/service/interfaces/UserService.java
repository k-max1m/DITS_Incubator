package incubator.service.interfaces;

import incubator.entity.User;

import java.util.List;

public interface UserService {
    public User getById(int id);
    public List<User> getAll();
    User findByLogin(String login);
    void deleteUserById(int id);
}
