package incubator.service;

import incubator.entity.Topic;
import incubator.repository.TopicRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicServiceImpl {
    @Autowired
    private TopicRepos topicRepos;

    public Topic getById(int id){return topicRepos.findById(id).get();}
}
