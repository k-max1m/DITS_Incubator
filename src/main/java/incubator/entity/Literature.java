package incubator.entity;

import javax.persistence.*;

@Entity
@Table(name = "literature")
public class Literature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int literatureId;
    private String description;

    @ManyToOne
    @JoinColumn(name = "questionId")
    private Question question;

    public Literature() {
    }

    public Literature(String description, Question question) {
        this.description = description;
        this.question = question;
    }

    public int getLiteratureId() {
        return literatureId;
    }

    public void setLiteratureId(int literatureId) {
        this.literatureId = literatureId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Literature{" +
                "literatureId=" + literatureId +
                ", description='" + description + '\'' +
                ", question=" + question +
                '}';
    }
}
