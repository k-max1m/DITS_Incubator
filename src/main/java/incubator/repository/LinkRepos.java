package incubator.repository;

import incubator.entity.Link;
import incubator.entity.Literature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LinkRepos extends JpaRepository<Link, Integer> {
    List<Link> findByLiterature(Literature literature);

    Link findLinkByLinkId(int id);

    Link findLinkByLink(String link);
}
