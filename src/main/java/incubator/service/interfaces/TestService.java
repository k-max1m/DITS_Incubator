package incubator.service.interfaces;

import incubator.entity.Test;

import java.util.List;

public interface TestService {
    List<Test> getAll();
    Test getById(int id);
    void save(Test test);
}
