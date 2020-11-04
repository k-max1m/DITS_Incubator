package incubator.service;

import incubator.entity.Link;
import incubator.entity.Literature;
import incubator.repository.LinkRepos;
import incubator.repository.LiteratureRepos;
import incubator.service.interfaces.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class LinkServiceImpl implements LinkService {
    @Autowired
    private LinkRepos linkRepos;

    @Autowired
    LiteratureRepos literatureRepos;

    @Override
    public List<Link> getAllByLiterature(List<Literature> literature) {
        List<Link> links = new ArrayList<>(literature.size());
        literature.forEach(o -> links.addAll(linkRepos.findByLiterature(o)));
        return links;
    }



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
