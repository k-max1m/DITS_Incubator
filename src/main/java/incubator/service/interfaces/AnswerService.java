package incubator.service.interfaces;

import incubator.entity.Answer;
import incubator.entity.Question;

import java.util.List;

public interface AnswerService {
    List<Answer> getAllAnswer();

    List<Answer> getAllByQuestion(Question question);

    Answer getByAnswerId(int id);

    Answer getByDescription(String description);

    void save(Answer answer);

    void updateDescription(Answer answer);

    void updateCorrect(Answer answer);

    void updateQuestion(Answer answer);
}
