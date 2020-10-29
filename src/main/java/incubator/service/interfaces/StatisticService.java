package incubator.service.interfaces;

import incubator.entity.Question;
import incubator.entity.Statistic;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface StatisticService {
    Statistic getById(int id);
    List<List<Object>> saveResultTest(Map<Question, Boolean> resultMap);
}
