package incubator.service.user;

import incubator.entity.User;
import incubator.repository.UserRepos;
import incubator.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepos userRepos;

    public User getById(int id){ return userRepos.findById(id).get();}

    @Override
    public List<User> getAll() {
        return userRepos.getUserByUserIdNotNull();
    }
    @Override
    public User findByLogin(String login){
        return userRepos.findByLogin(login);
    }

    @Override
    public void deleteUserById(int id) {
        userRepos.delete(userRepos.getByUserId(id));
    }
}
