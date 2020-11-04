package incubator.service.interfaces;

import incubator.entity.Test;
import incubator.entity.Topic;

import java.util.List;

public interface TestService {
    List<Test> getAll();

    Test getById(int id);

    void save(Test test);

    List<String> getNamesTestsByTopic(String topic);

    Test getTestByName(String name);

    List<Test> getTestsByTopic(Topic topic);
}
