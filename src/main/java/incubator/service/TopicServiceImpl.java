package incubator.service;

import incubator.entity.Topic;
import incubator.repository.TopicRepos;
import incubator.service.interfaces.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class TopicServiceImpl implements TopicService {
    private TopicRepos topicRepos;

    @Autowired
    public TopicServiceImpl(TopicRepos topicRepos) {
        this.topicRepos = topicRepos;
    }

    public Topic getById(int id){return topicRepos.findById(id).get();}

    public List<Topic> getAllTopic() {
        return topicRepos.findAll();
    }

    @Override
    public void save(Topic topic) {
        topicRepos.save(topic);
    }
}
