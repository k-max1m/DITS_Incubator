package incubator.repository;

import incubator.entity.Link;
import incubator.entity.Literature;
import incubator.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LiteratureRepos extends JpaRepository<Literature, Integer> {
    List<Literature> findByQuestion(Question question);

    Literature findByLiteratureId(int id);

    Literature findByDescription(String description);
}
