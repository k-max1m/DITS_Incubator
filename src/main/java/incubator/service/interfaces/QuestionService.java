package incubator.service.interfaces;

import incubator.entity.Question;
import incubator.entity.Test;

import java.util.List;

public interface QuestionService {
    List<Question> getAllQuestion();

    List<Question> getAllByTest(Test test);

    Question getByQuestionId(int id);

    Question getByDescription(String description);

    void save(Question question);

    void updateDescription(Question question);

    void updateTest(Question question);

    void deleteQuestion(Question question);
}
