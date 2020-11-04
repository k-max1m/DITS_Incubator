package incubator.repository;

import incubator.entity.Link;
import incubator.entity.Question;
import incubator.entity.Statistic;
import incubator.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface StatisticRepos extends JpaRepository<Statistic,Integer> {
    Statistic getByStatisticId(int id);
    List<Statistic> getAllByCorrect(boolean correct);
    List<Statistic> getAllByDate(Date date);
    List<Statistic> getAllByUser(User user);
    List<Statistic> getAllByQuestion(Question question);
    List<Statistic> getAllByQuestionAndUser(Question question, User user);
}
