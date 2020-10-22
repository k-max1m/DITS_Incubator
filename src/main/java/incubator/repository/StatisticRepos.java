package incubator.repository;

import incubator.entity.Statistic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatisticRepos extends JpaRepository<Statistic,Integer> {
}
