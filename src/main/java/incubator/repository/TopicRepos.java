package incubator.repository;

import incubator.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicRepos extends JpaRepository<Topic, Integer> {
    Topic findByTopicId(int id);
    List<Topic> getAllByName(String name);
}

