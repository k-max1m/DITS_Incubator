package incubator.service.user;

import incubator.entity.Topic;
import incubator.repository.TopicRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicAnswer {
    @Autowired
    private TopicRepos topicRepos;

    public Topic getById(int id){return topicRepos.findById(id).get();}
}
