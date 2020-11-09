package incubator.service.interfaces;

import incubator.entity.Link;
import incubator.entity.Literature;

import java.util.List;

public interface LinkService {
    List<Link> getAllByLiterature(List<Literature> literature);

    Link getById(int id);

    void save(Link link);

    List<Link> getByLiteratureId(int id);

    void updateLink(Link link);

    void updateLiterature(Link link);

    void deleteLink(Link link);

    List<Link> getAll();
}
