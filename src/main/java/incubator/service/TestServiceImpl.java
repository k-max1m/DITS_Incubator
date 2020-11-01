package incubator.service;

import incubator.entity.Test;
import incubator.repository.TestRepos;
import incubator.service.interfaces.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestRepos testRepos;
    @Override
    public Test getById(int id){return testRepos.findById(id).get();}

    @Override
    public List<Test> getAll() {
        return testRepos.findAllByTestIdNotNull();
    }

}
