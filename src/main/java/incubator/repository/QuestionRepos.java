package incubator.repository;


import incubator.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepos extends JpaRepository<Question,Integer> {
}
