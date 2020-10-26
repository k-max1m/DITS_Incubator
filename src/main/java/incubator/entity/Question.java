package incubator.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "question")
public class Question implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int questionId;
    private String description;

    @ManyToOne
    @JoinColumn(name = "testId")
    private Test test;

    public Question() {
    }

    public Question(String description, Test test) {
        this.description = description;
        this.test = test;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionId=" + questionId +
                ", description='" + description + '\'' +
                ", test=" + test +
                '}';
    }
}
