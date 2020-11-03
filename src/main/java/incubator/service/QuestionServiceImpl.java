package incubator.service;

import incubator.entity.Question;
import incubator.entity.Test;
import incubator.repository.QuestionRepos;
import incubator.service.interfaces.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {

    private QuestionRepos questionRepos;

    @Autowired
    public QuestionServiceImpl(QuestionRepos questionRepos) {
        this.questionRepos = questionRepos;
    }

    @Override
    public List<Question> getAllQuestion() {
        return questionRepos.findAll();
    }

    @Override
    public List<Question> getAllByTest(Test test) {
        return questionRepos.findByTest(test);
    }

    @Override
    public Question getByQuestionId(int id) {
        return questionRepos.findByQuestionId(id);
    }

    @Override
    public Question getByDescription(String description) {
        return questionRepos.findByDescription(description);
    }
}
