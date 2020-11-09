package incubator.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "user_statistic")
public class UserStatistic implements Serializable {

    @Id
    private int id;
    private int userId;
    private String firstAndLastName;
    private String testName;
    private String questionDescription;
    private int allAnswers;
    private int correctAnswers;
    private double percent;

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstAndLastName() {
        return firstAndLastName;
    }

    public void setFirstAndLastName(String firstAndLastName) {
        this.firstAndLastName = firstAndLastName;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getQuestionDescription() {
        return questionDescription;
    }

    public void setQuestionDescription(String questionDescription) {
        this.questionDescription = questionDescription;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAllAnswers() {
        return allAnswers;
    }

    public void setAllAnswers(int allAnswers) {
        this.allAnswers = allAnswers;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(int correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    @Override
    public String toString() {
        return "UserStatistic{" +
                "userId=" + userId +
                ", firstAndLastName='" + firstAndLastName + '\'' +
                ", testName='" + testName + '\'' +
                ", questionDescription='" + questionDescription + '\'' +
                ", allAnswers=" + allAnswers +
                ", correctAnswers=" + correctAnswers +
                '}';
    }
}
