package incubator.service;

import incubator.entity.Link;
import incubator.repository.LinkRepos;
import incubator.service.interfaces.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class LinkServiceImpl implements LinkService {
    @Autowired
    LinkRepos linkRepos;

    public Link getById(int id){return linkRepos.findById(id).get();}
}
