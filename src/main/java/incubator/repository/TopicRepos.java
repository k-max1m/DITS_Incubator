package incubator.repository;

import incubator.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepos extends JpaRepository<Topic, Integer> {
    Topic findByTopicId(int id);

    Topic findByName(String name);
}

