package incubator.service;

import incubator.entity.Statistic;
import incubator.repository.StatisticRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatisticServiceImpl {
    @Autowired
    private StatisticRepos statisticRepos;

    public Statistic getById(int id){return statisticRepos.findById(id).get();}
}
