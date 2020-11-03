package incubator.service;

import incubator.entity.Link;
import incubator.repository.LinkRepos;
import incubator.repository.LiteratureRepos;
import incubator.service.interfaces.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class LinkServiceImpl implements LinkService {
    @Autowired
    LinkRepos linkRepos;
    @Autowired
    LiteratureRepos literatureRepos;

    public Link getById(int id){return linkRepos.findById(id).get();}

    @Override
    public void save(Link link) {
        linkRepos.save(link);
    }

    @Override
    public List<Link> getByLiteratureId(int id) {
        return linkRepos.findLinkByLiterature(literatureRepos.findByLiteratureId(id));
    }
}
