package incubator.service.interfaces;

import incubator.entity.Literature;
import incubator.entity.Question;

import java.util.List;

public interface LiteratureService {
    List<Literature> getAllLiterature();

    List<Literature> getAllByQuestion(Question question);

    Literature getByLiteratureId(int id);

   Literature getByDescription(String description);
   void save(Literature literature);
}
