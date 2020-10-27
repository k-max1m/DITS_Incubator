package incubator.service.user;

import incubator.entity.Test;
import incubator.repository.TestRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestAnswer {
    @Autowired
    private TestRepos testRepos;

    public Test getById(int id){return testRepos.findById(id).get();}
}
