package incubator.service;

import incubator.entity.Answer;
import incubator.entity.Question;
import incubator.repository.AnswerRepos;
import incubator.service.interfaces.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerRepos answerRepos;

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
}
