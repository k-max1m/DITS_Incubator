package incubator.repository;

import incubator.entity.Answer;
import incubator.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface AnswerRepos extends JpaRepository<Answer, Integer> {
    Answer findByAnswerId(int id);

    List<Answer> findByQuestion(Question question);

    Answer findByDescription(String description);

    @Modifying
    @Query("update Answer a set a.correct = :value where a.answerId = :id")
    void updateCorrect(@Param(value = "value") boolean value, @Param(value = "id") int id);

    @Modifying
    @Query("update Answer a set a.description = :value where a.answerId = :id")
    void updateDescription(@Param(value = "value") String value, @Param(value = "id") int id);

    @Modifying
    @Query("update Answer a set a.question = :value where a.answerId = :id")
    void updateQuestion(@Param(value = "value") Question value, @Param(value = "id") int id);

}
