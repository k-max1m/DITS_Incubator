package incubator.service.user;

import incubator.entity.Literature;
import incubator.repository.LiteratureRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LiteratureAnswer {
    @Autowired
    private LiteratureRepos literatureRepos;

    public Literature getById(int id){return literatureRepos.findById(id).get();}
}
