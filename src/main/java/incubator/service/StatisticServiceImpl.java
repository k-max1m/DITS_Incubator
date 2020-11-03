package incubator.service;

import incubator.entity.Question;
import incubator.entity.Statistic;
import incubator.entity.User;
import incubator.repository.StatisticRepos;
import incubator.service.interfaces.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service
public class StatisticServiceImpl implements StatisticService {
    @Autowired
    private StatisticRepos statisticRepos;
    @Override
    public Statistic getById(int id){return statisticRepos.findById(id).get();}
    @Override
    public List<Statistic> getByUser(User user){return statisticRepos.getAllByUser(user);}

    @Override
    public List<Statistic> getByQuestionAndUser(Question question, User user) {
        return statisticRepos.getAllByQuestionAndUser(question, user);
    }

    @Override
    public List<Statistic> getByQuestion(Question question) {
        return statisticRepos.getAllByQuestion(question);
    }

    @Override
    public void save(Statistic statistic) {
        statisticRepos.save(statistic);
    }

}
