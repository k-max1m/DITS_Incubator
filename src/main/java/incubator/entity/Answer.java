package incubator.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "answer")
public class Answer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int answerId;
    private String description;
    private boolean correct;

    @ManyToOne
    @JoinColumn(name = "questionId")
    private Question question;

    public Answer() {
    }

    public Answer(String description, boolean correct) {
        this.description = description;
        this.correct = correct;
    }

    public Answer(String description, boolean correct, Question question) {
        this.correct = correct;
        this.description = description;
        this.question = question;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    @Override
    public String toString() {
        return "Answer{" +
                "answerId=" + answerId +
                ", description='" + description + '\'' +
                ", correct=" + correct +
                ", question=" + question +
                '}';
    }
}
