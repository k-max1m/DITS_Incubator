package incubator.repository;

import incubator.entity.Literature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LiteratureRepos extends JpaRepository<Literature, Integer> {
}
