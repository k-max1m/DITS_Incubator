package incubator.service.interfaces;

import incubator.entity.Topic;

import java.util.List;

public interface TopicService {
    Topic getById(int id);

    void save(Topic topic);

    List<Topic> getAllTopic();
}
