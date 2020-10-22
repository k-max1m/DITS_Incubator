package incubator.service.user;

import incubator.entity.Question;
import incubator.repository.QuestionRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionAnswer {
    @Autowired
    private QuestionRepos questionRepos;

    public Question getById(int id){return questionRepos.findById(id).get();}
}
