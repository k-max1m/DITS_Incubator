package incubator.service;

import incubator.entity.User;
import incubator.entity.UserStatistic;
import incubator.repository.UserRepos;
import incubator.repository.UserStatisticRepo;
import incubator.service.interfaces.UserStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserStatisticServiceImpl implements UserStatisticService {
    @Autowired
    private UserStatisticRepo userStatisticRepo;

    @Autowired
    private UserRepos userRepos;

    @Override
    public UserStatistic getUserStatistic() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User user = userRepos.findByLogin(userName);
        List<UserStatistic> all = userStatisticRepo.findAll();
        return all.stream().filter(o -> o.getUserId() == user.getUserId()).findAny().orElse(null);
    }
}
