package incubator.service.interfaces;

import incubator.entity.Question;
import incubator.entity.Statistic;
import incubator.entity.User;

import java.util.List;

public interface StatisticService {
    Statistic getById(int id);
    List<Statistic> getByUser(User user);
    List<Statistic> getByQuestinAndUser(Question question, User user);
}
