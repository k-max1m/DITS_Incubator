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
    private LiteratureRepos literatureRepos;

    @Autowired
    public LiteratureServiceImpl(LiteratureRepos literatureRepos) {
        this.literatureRepos = literatureRepos;
    }

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

    @Override
    public void save(Literature literature) {
        literatureRepos.save(literature);
    }

    @Override
    public void updateDescription(Literature literature){
        literatureRepos.updateDescription(literature.getDescription(), literature.getLiteratureId());
    }

    @Override
    public void updateQuestion(Literature literature){
        literatureRepos.updateQuestion(literature.getQuestion(), literature.getLiteratureId());
    }

    @Override
    public void deleteLiterature(Literature literature){
        literatureRepos.delete(literature);
    }
}
