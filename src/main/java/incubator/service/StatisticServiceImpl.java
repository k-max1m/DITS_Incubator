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


import java.util.*;
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
    public List<List<Object>> saveResultTest(Map<Question, List<Boolean>> correctQuestion) {
        Date date = new Date();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User user = userRepos.findByLogin(userName);


        List<List<Object>> resultList = new ArrayList<>();
        for (Map.Entry<Question, List<Boolean>> question : correctQuestion.entrySet()) {
            boolean fail = false;
            for (Boolean bool : question.getValue()) {
                if (!bool) {
                    fail = true;
                    break;
                }
            }
            List<Object> stepList = new ArrayList<>();
            String right = "";
            if (fail) {
                stepList.add(question.getKey().getDescription());
                right = "-";
                stepList.add(right);
                List<Literature> literature = literatureService.getAllByQuestion(question.getKey());
                System.out.println(literature.size());
                stepList.add(literature.stream().map(Literature::getDescription).collect(Collectors.toList()));
                stepList.add(linkService.getAllByLiterature(literature).stream()
                        .map(Link::getLink).collect(Collectors.toList()));
                resultList.add(stepList);
            }
        }

        double allAnswer = correctQuestion.size();
        double incorrectAnswer = resultList.size();
        double resultTest = (allAnswer - incorrectAnswer)/allAnswer * 100;
        List<Object> res = new ArrayList<>(1);
        res.add(String.format("%.2f", resultTest));

        resultList.add(res);

        correctQuestion.forEach((key, value) -> {
            boolean right = true;
            for(Boolean bool: value) {
                if (!bool) {
                    right = false;
                    break;
                }
            }
            Statistic statistic = new Statistic(date, right, key, user);
            Statistic save = statisticRepos.saveAndFlush(statistic);
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
