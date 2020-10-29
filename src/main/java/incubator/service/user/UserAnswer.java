package incubator.service.user;

import incubator.entity.User;
import incubator.repository.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserAnswer {
    @Autowired
    private UserRepos userRepos;

    public User getById(int id){ return userRepos.findById(id).get();}
}
