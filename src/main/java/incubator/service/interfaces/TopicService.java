package incubator.service.interfaces;

import incubator.entity.Topic;

import java.util.List;

public interface TopicService {
    Topic getById(int id);

    void save(Topic topic);

    List<Topic> getAllTopic();

    void updateDescription(Topic topic);

    void updateName(Topic topic);

    void deleteTopic(Topic topic);

    Topic getByDescription(String description);

}
