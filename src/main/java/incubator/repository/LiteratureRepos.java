package incubator.repository;

import incubator.entity.Link;
import incubator.entity.Literature;
import incubator.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LiteratureRepos extends JpaRepository<Literature, Integer> {
    List<Literature> findByQuestion(Question question);

    Literature findByLiteratureId(int id);

    Literature findByDescription(String description);

    @Modifying
    @Query("update Literature l set l.description = :value where l.literatureId = :Id")
    void updateDescription(@Param(value = "value") String value, @Param(value = "Id") int litId);

    @Modifying
    @Query("update Literature l set l.question = :value where l.literatureId = :Id")
    void updateQuestion(@Param(value = "value") Question value, @Param(value = "Id") int Id);


}
