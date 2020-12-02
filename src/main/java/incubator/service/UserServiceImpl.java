package incubator.service;

import incubator.entity.User;
import incubator.repository.RoleRepos;
import incubator.repository.UserRepos;
import incubator.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepos userRepos;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private RoleRepos roleRepos;

    public User getById(int id) {
        return userRepos.findById(id).get();
    }


    @Override
    public List<User> getAll() {
        return userRepos.getUserByUserIdNotNull();
    }

    @Override
    public User findByLogin(String login) {
        return userRepos.findByLogin(login);
    }

    @Override
    public void deleteUserById(int id) {
        userRepos.delete(userRepos.getByUserId(id));
    }

    @Override
    public boolean save(User user){
        User aUser = userRepos.findByLogin(user.getLogin());
        if(aUser != null){
            return false;
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepos.save(user);
        return true;
    }

    @Override
    public void updatePassword(User user) {
        userRepos.updatePassword(user.getPassword(),user.getUserId());
    }

    @Override
    public void updateFirstName(User user) {
        userRepos.updateFirstName(user.getFirstName(),user.getUserId());
    }

    @Override
    public void updateLastName(User user) {
        userRepos.updateLastName(user.getLastName(),user.getUserId());
    }

    @Override
    public void updateLogin(User user) {
        userRepos.updateLogin(user.getLogin(),user.getUserId());
    }

    @Override
    public void updateRole(User user) { userRepos.updateRole(user.getRole(), user.getUserId()); }
}
