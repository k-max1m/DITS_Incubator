package incubator.entity;

import javax.persistence.*;

@Entity
@Table(name="topic")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int topicId;
    private String description;
    private String name;

    public Topic(String description, String name) {
        this.description = description;
        this.name = name;
    }

    public Topic() {
    }

    @Override
    public String toString() {
        return "Topic{" +
                "topicId=" + topicId +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public int getTopicId() {
        return topicId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
