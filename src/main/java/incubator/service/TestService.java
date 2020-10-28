package incubator.service;

import incubator.entity.Test;
import incubator.repository.TestRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    @Autowired
    private TestRepos testRepos;

    public Test getById(int id){return testRepos.findById(id).get();}
}
