package incubator.service;

import incubator.entity.Topic;
import incubator.repository.TopicRepos;
import incubator.service.interfaces.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicServiceImpl implements TopicService {
    @Autowired
    private TopicRepos topicRepos;

    public Topic getById(int id){return topicRepos.findById(id).get();}

    @Override
    public void save(Topic topic) {
        topicRepos.save(topic);
    }
}
