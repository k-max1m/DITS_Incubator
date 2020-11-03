package incubator.service;

import incubator.entity.User;
import incubator.repository.UserRepos;
import incubator.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepos userRepos;

    public User getById(int id){ return userRepos.findById(id).get();}
}
