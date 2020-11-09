package incubator.repository;

import incubator.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicRepos extends JpaRepository<Topic, Integer> {
    Topic findByTopicId(int id);

    Topic findByName(String name);

    List<Topic> getAllByName(String name);

    @Modifying
    @Query("update Topic t set t.description = :value where t.topicId = :Id")
    void updateDescription(@Param(value = "value") String value, @Param(value = "Id") int Id);

    @Modifying
    @Query("update Topic t set t.name = :value where t.topicId = :Id")
    void updateName(@Param(value = "value") String value, @Param(value = "Id") int Id);


}

