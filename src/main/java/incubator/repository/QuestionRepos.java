package incubator.repository;

import incubator.entity.Question;
import incubator.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface QuestionRepos extends JpaRepository<Question, Integer> {
    Question findByQuestionId(int questionId);

    List<Question> findByTest(Test test);

    Question findByDescription(String description);
}
