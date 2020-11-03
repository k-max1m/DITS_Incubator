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

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserStatisticServiceImpl implements UserStatisticService {
    private UserStatisticRepo userStatisticRepo;

    private UserRepos userRepos;

    @Autowired
    public UserStatisticServiceImpl(UserStatisticRepo userStatisticRepo, UserRepos userRepos) {
        this.userStatisticRepo = userStatisticRepo;
        this.userRepos = userRepos;
    }

    @Override
    public List<UserStatistic> getUserStatistic() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User user = userRepos.findByLogin(userName);
        List<UserStatistic> all = userStatisticRepo.findAll();
        return all.stream().filter(o -> o.getUserId() == user.getUserId()).collect(Collectors.toList());
    }
}
