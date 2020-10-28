package incubator.service;

import incubator.entity.Test;
import incubator.entity.Topic;
import incubator.repository.TestRepos;
import incubator.repository.TopicRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestServiceImpl {
    @Autowired
    private TestRepos testRepos;

    @Autowired
    private TopicRepos topicRepos;

    public Test getById(int id){return testRepos.findById(id).get();}

    public List<Test> getTestsByTopic(Topic topic) {
        return testRepos.findByTopic(topic);
    }

    public List<String> getNamesTestsByTopic(String topic) {
        Topic topicToTests = topicRepos.findByName(topic);
        List<String> testsNames = testRepos.findByTopic(topicToTests).stream().map(Test::getName).collect(Collectors.toList());
        return testsNames;
    }

    public Test getTestByName(String name) {
        return testRepos.findByName(name);
    }
}
