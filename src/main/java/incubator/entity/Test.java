package incubator.entity;

import javax.persistence.*;

@Entity
@Table(name="test")
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int testId;
    private String name;
    private String description;
    @ManyToOne
    @JoinColumn(name = "topicId")
    private Topic topic;

    public Test() {
    }

    @Override
    public String toString() {
        return "Test{" +
                "testId=" + testId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", topic=" + topic +
                '}';
    }

    public int getTestId() {
        return testId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Test(String name, String description, Topic topic) {
        this.name = name;
        this.description = description;
        this.topic = topic;
    }
}
