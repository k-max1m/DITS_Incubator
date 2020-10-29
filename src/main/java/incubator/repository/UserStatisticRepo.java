package incubator.repository;

import incubator.entity.UserStatistic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserStatisticRepo extends JpaRepository<UserStatistic, Integer> {
    UserStatistic findByUserId(int id);
}
