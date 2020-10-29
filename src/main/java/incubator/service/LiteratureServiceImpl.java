package incubator.service;

import incubator.entity.Literature;
import incubator.entity.Question;
import incubator.repository.LiteratureRepos;
import incubator.service.interfaces.LiteratureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LiteratureServiceImpl implements LiteratureService {

    @Autowired
    private LiteratureRepos literatureRepos;

    @Override
    public List<Literature> getAllLiterature() {
        return literatureRepos.findAll();
    }

    @Override
    public List<Literature> getAllByQuestion(Question question) {
        return literatureRepos.findByQuestion(question);
    }

    @Override
    public Literature getByLiteratureId(int id) {
        return literatureRepos.findByLiteratureId(id);
    }

    @Override
    public Literature getByDescription(String description) {
        return literatureRepos.findByDescription(description);
    }
}
