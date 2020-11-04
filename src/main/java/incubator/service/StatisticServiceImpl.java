package incubator.service;

import incubator.entity.*;
import incubator.repository.StatisticRepos;
import incubator.repository.UserRepos;
import incubator.service.interfaces.LinkService;
import incubator.service.interfaces.LiteratureService;
import incubator.service.interfaces.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
public class StatisticServiceImpl implements StatisticService {
    private LiteratureService literatureService;
    private LinkService linkService;
    private StatisticRepos statisticRepos;
    private UserRepos userRepos;

    @Autowired
    public StatisticServiceImpl(LiteratureService literatureService, LinkService linkService, StatisticRepos statisticRepos, UserRepos userRepos) {
        this.literatureService = literatureService;
        this.linkService = linkService;
        this.statisticRepos = statisticRepos;
        this.userRepos = userRepos;
    }

    public Statistic getById(int id){return statisticRepos.findById(id).get();}

    @Override
    public List<List<Object>> saveResultTest(Map<Question, Boolean> correctQuestion) {
        Date date = new Date();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User user = userRepos.findByLogin(userName);

        List<List<Object>> resultList = new ArrayList<>();
        for (Map.Entry<Question, Boolean> question : correctQuestion.entrySet()) {
            List<Object> stepList = new ArrayList<>();
            stepList.add(question.getKey().getDescription());
            String right = "";
            if (question.getValue()) {
                right = "+";
            } else {
                right = "-";
            }
            stepList.add(right);
            List<Literature> literature = literatureService.getAllByQuestion(question.getKey());
            System.out.println(literature.size());
            stepList.add(literature.stream().map(Literature::getDescription).collect(Collectors.toList()));
            stepList.add(linkService.getAllByLiterature(literature).stream()
                    .map(Link::getLink).collect(Collectors.toList()));
            resultList.add(stepList);
        }

        correctQuestion.forEach((key, value) -> {
            Statistic statistic = new Statistic(date, value, key, user);
            System.out.println(user);
            Statistic save = statisticRepos.saveAndFlush(statistic);
            System.out.println(save);

        });

        return resultList;
    }


    @Override
    public List<Statistic> getByUser(User user){return statisticRepos.getAllByUser(user);}

    @Override
    public List<Statistic> getByQuestionAndUser(Question question, User user) {
        return statisticRepos.getAllByQuestionAndUser(question, user);
    }

    @Override
    public List<Statistic> getByQuestion(Question question) {
        return statisticRepos.getAllByQuestion(question);
    }

    @Override
    public void save(Statistic statistic) {
        statisticRepos.save(statistic);
    }

}
