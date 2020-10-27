package incubator.service.user;

import incubator.entity.Link;
import incubator.repository.LinkRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkAnswer {
    @Autowired
    LinkRepos linkRepos;

    public Link getById(int id){return linkRepos.findById(id).get();}
}