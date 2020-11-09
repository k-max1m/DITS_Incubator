package incubator.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="statistic")
public class Statistic implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int statisticId;
    private Date date;
    private boolean correct;

    @Transient
    private int questionId;
    @Transient
    private int userId;

    public Statistic(Date date, boolean correct, int questionId, int userId) {
        this.date = date;
        this.correct = correct;
        this.questionId = questionId;
        this.userId = userId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @ManyToOne
    @JoinColumn(name="questionId")
    private Question question;
    @ManyToOne
    @JoinColumn(name="userId")
    private User user;

    public Statistic() {
    }

    public Statistic(Date date, boolean correct, Question question, User user) {
        this.date = date;
        this.correct = correct;
        this.question = question;
        this.user = user;
    }

    @Override
    public String toString() {
        return "Statistic{" +
                "statisticId=" + statisticId +
                ", date=" + date +
                ", correct=" + correct +
                ", question=" + question +
                ", user=" + user +
                '}';
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getStatisticId() {
        return statisticId;
    }

    public void setStatisticId(int statisticId) {
        this.statisticId = statisticId;
    }
}
