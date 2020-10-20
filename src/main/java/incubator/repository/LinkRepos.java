package incubator.repository;

import incubator.entity.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkRepos extends JpaRepository<Link, Integer> {
}
