package incubator.service.user;

import incubator.entity.Answer;
import incubator.repository.AnswerRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {
    @Autowired
    AnswerRepos answerRepos;

    public Answer getById(int id) {
        return answerRepos.findById(id).get();
    }
}
