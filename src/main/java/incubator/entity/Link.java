package incubator.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "link")
public class Link implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int linkId;
    private String link;

    @Transient
    private int literatureId;

    public Link(String link, int literatureId) {
        this.link = link;
        this.literatureId = literatureId;
    }

    public int getLiteratureId() {
        return literatureId;
    }

    public void setLiteratureId(int literatureId) {
        this.literatureId = literatureId;
    }

    @ManyToOne
    @JoinColumn(name = "literatureId")
    private Literature literature;

    public Link() {
    }

    public Link(String link, Literature literature) {
        this.link = link;
        this.literature = literature;
    }

    public int getLinkId() {
        return linkId;
    }

    public void setLinkId(int linkId) {
        this.linkId = linkId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Literature getLiterature() {
        return literature;
    }

    public void setLiterature(Literature literature) {
        this.literature = literature;
    }

    @Override
    public String toString() {
        return "Link{" +
                "linkId=" + linkId +
                ", link='" + link + '\'' +
                ", literature=" + literature.getLiteratureId() +
                '}';
    }
}
