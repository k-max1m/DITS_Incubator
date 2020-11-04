package incubator.service.interfaces;

import incubator.entity.Link;
import incubator.entity.Literature;

import java.util.List;

public interface LinkService {
    List<Link> getAllByLiterature(List<Literature> literature);

    Link getById(int id);

    void save(Link link);

    List<Link> getByLiteratureId(int id);

}
