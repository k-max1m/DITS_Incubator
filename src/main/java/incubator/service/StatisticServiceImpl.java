package incubator.service;

import incubator.entity.Statistic;
import incubator.repository.StatisticRepos;
import incubator.service.interfaces.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatisticServiceImpl implements StatisticService {
    @Autowired
    private StatisticRepos statisticRepos;

    public Statistic getById(int id){return statisticRepos.findById(id).get();}
}
