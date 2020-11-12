package incubator.service;

import incubator.entity.Answer;
import incubator.entity.Question;
import incubator.repository.AnswerRepos;
import incubator.service.interfaces.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AnswerServiceImpl implements AnswerService {
    private AnswerRepos answerRepos;

    @Autowired
    public AnswerServiceImpl(AnswerRepos answerRepos) {
        this.answerRepos = answerRepos;
    }

    @Override
    public List<Answer> getAllAnswer() {
        return answerRepos.findAll();
    }

    @Override
    public List<Answer> getAllByQuestion(Question question) {
        return answerRepos.findByQuestion(question);
    }

    @Override
    public Answer getByAnswerId(int id) {
        return answerRepos.findByAnswerId(id);
    }

    @Override
    public Answer getByDescription(String description) {
        return answerRepos.findByDescription(description);
    }

    @Override
    public void save(Answer answer) {
        answerRepos.save(answer);
    }

    @Override
    public boolean getCorrectByAnswersIds(Question question, List<Integer> answerId) {
        boolean correct = true;

        List<Integer> answerIdCorrect = answerRepos.findByQuestion(question).stream()
                .filter(Answer::isCorrect)
                .map(Answer::getAnswerId)
                .collect(Collectors.toList());

        if(!(answerId.size() == answerIdCorrect.size())) {
            return false;
        }
        for (Integer id : answerId) {
            if (!(answerIdCorrect.contains(id))) {
                return false;
            }
        }

        return true;
    }
}
