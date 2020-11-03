package incubator.service.interfaces;

import incubator.entity.Test;
import incubator.entity.Topic;

import java.util.List;

public interface TestService {
    List<Test> getTestsByTopic(Topic topic);
    List<String> getNamesTestsByTopic(String topic);
    Test getTestByName(String name);
}
