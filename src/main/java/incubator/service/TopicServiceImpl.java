package incubator.service;

import incubator.entity.Topic;
import incubator.repository.TopicRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TopicServiceImpl {
    @Autowired
    private TopicRepos topicRepos;

    public Topic getById(int id){return topicRepos.findById(id).get();}

    public List<Topic> getAllTopic() {
        return topicRepos.findAll();
    }
}
