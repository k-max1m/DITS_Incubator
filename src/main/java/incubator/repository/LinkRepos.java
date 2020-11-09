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
public interface LinkRepos extends JpaRepository<Link, Integer> {
    List<Link> findByLiterature(Literature literature);

    Link findLinkByLinkId(int id);

    Link findLinkByLink(String link);

    List<Link> findLinkByLiterature(Literature literature);

    @Modifying
    @Query("update Link l set l.link = :value where l.linkId = :Id")
    void updateLink(@Param(value = "value") String value, @Param(value = "Id") int Id);

    @Modifying
    @Query("update Link l set l.literature = :value where l.linkId = :Id")
    void updateLiterature(@Param(value = "value") Literature value, @Param(value = "Id") int Id);


}
