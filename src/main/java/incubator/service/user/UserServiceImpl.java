package incubator.service.user;

import incubator.entity.User;
import incubator.repository.UserRepos;
import incubator.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepos userRepos;

    public User getById(int id){ return userRepos.findById(id).get();}

    @Override
    public List<User> getAll() {
        return userRepos.getUserByUserIdNotNull();
    }
}
