package incubator.service.interfaces;

import incubator.entity.Link;

import java.util.List;

public interface LinkService {
    Link getById(int id);
    void save(Link link);
    List<Link> getByLiteratureId(int id);
}
