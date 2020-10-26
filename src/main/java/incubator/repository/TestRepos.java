package incubator.repository;

import incubator.entity.Test;
import incubator.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestRepos extends JpaRepository<Test, Integer> {
    List<Test> findByTopic(Topic topic);


    Test findByTestId(int id);
}