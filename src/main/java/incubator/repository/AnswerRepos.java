package incubator.repository;

import incubator.entity.Answer;
import incubator.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface AnswerRepos extends JpaRepository<Answer, Integer> {
    Answer findByAnswerId(int id);

    List<Answer> findByQuestion(Question question);

    Answer findByDescription(String description);

}
