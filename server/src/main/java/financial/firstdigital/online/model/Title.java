package financial.firstdigital.online.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * The Title class contains information
 * about the customer titles
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-09-20
 */

@Entity
@Table(name = "fdf_title")
public class Title {

    @Id
    @GeneratedValue
    @Column(name = "titleId", columnDefinition = "serial")
    private int titleId;

    @Column(name = "title", length = 13)
    private String title;

    @JsonIgnore
    public int getTitleId() {
        return titleId;
    }

    public void setTitleId(int titleId) {
        this.titleId = titleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Title{" +
                "titleId=" + titleId +
                ", title='" + title + '\'' +
                '}';
    }
}
