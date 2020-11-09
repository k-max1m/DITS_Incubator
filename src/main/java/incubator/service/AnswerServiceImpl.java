package incubator.service;

import incubator.entity.Answer;
import incubator.entity.Question;
import incubator.repository.AnswerRepos;
import incubator.service.interfaces.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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
    public void updateDescription(Answer answer){
        answerRepos.updateDescription(answer.getDescription(), answer.getAnswerId());
    }

    @Override
    public void updateCorrect(Answer answer){
        answerRepos.updateCorrect(answer.isCorrect(), answer.getAnswerId());
    }

    @Override
    public void updateQuestion(Answer answer){
        answerRepos.updateQuestion(answer.getQuestion(), answer.getAnswerId());
    }

}
