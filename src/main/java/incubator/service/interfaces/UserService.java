package incubator.service.interfaces;

import incubator.entity.User;

import java.util.List;

public interface UserService {
    public User getById(int id);
    public List<User> getAll();
    public User save(User user);
}
