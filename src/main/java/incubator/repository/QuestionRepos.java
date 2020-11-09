package incubator.repository;

import incubator.entity.Question;
import incubator.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface QuestionRepos extends JpaRepository<Question, Integer> {
    Question findByQuestionId(int questionId);

    List<Question> findByTest(Test test);

    Question findByDescription(String description);

    @Modifying
    @Query("update Question q set q.description = :value where q.questionId = :Id")
    void updateDescription(@Param(value = "value") String value, @Param(value = "Id") int litId);

    @Modifying
    @Query("update Question q set q.test = :value where q.questionId = :Id")
    void updateTest(@Param(value = "value") Test value, @Param(value = "Id") int Id);


}

