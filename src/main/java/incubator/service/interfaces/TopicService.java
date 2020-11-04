package incubator.service.interfaces;

import incubator.entity.Topic;

public interface TopicService {
    Topic getById(int id);
    void save(Topic topic);
}
