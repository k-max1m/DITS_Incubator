package incubator.repository;

import incubator.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepos extends JpaRepository<Answer, Integer> {
}
