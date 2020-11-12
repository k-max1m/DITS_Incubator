package incubator.service.interfaces;

import incubator.entity.Question;
import incubator.entity.Statistic;
import incubator.entity.User;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface StatisticService {
    Statistic getById(int id);

    List<List<Object>> saveResultTest(Map<Question, List<Integer>> resultMap);

    List<Statistic> getByUser(User user);

    List<Statistic> getByQuestionAndUser(Question question, User user);

    List<Statistic> getByQuestion(Question question);

    void save(Statistic statistic);

}
