package incubator.repository;

import incubator.entity.Test;
import incubator.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestRepos extends JpaRepository<Test, Integer> {
    List<Test> findAllByTestIdNotNull();

    List<Test> findByTopic(Topic topic);

    Test findByTestId(int id);

    Test findByName(String name);

    List<Test> getAllByName(String name);

    List<Test> getAllByTopic(Topic topic);

    @Modifying
    @Query("update Test t set t.description = :value where t.testId = :Id")
    void updateDescription(@Param(value = "value") String value, @Param(value = "Id") int Id);

    @Modifying
    @Query("update Test t set t.name = :value where t.testId = :Id")
    void updateName(@Param(value = "value") String value, @Param(value = "Id") int Id);

    @Modifying
    @Query("update Test t set t.topic = :value where t.testId = :Id")
    void updateTopic(@Param(value = "value") Topic value, @Param(value = "Id") int Id);


}
