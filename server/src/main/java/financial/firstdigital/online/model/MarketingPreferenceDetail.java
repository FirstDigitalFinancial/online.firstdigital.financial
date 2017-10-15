package financial.firstdigital.online.model;

import javax.persistence.*;

/**
 * The MarketingPreferenceDetail class contains information
 * about the customers marketing preferences
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-09-20
 */

@Entity
@Table(name = "fdf_marketing_preference_detail")
public class MarketingPreferenceDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "marketingPreferenceId", columnDefinition = "serial")
    private Long marketingPreferenceId;

    @Column(name = "email")
    Boolean byEmail;

    @Column(name = "post")
    Boolean byPost;

    @Column(name = "phone")
    Boolean byPhone;

    @Column(name = "text")
    Boolean byText;

    @Column(name = "app")
    Boolean byApp;

    @Column(name = "social")
    Boolean bySocial;

    public MarketingPreferenceDetail() {
        this.byEmail = false;
        this.byPost = false;
        this.byPhone = false;
        this.byText = false;
        this.byApp = false;
        this.bySocial = false;
    }

    public MarketingPreferenceDetail(Long marketingPreferenceId,
                                     Boolean byEmail,
                                     Boolean byPost,
                                     Boolean byPhone,
                                     Boolean byText,
                                     Boolean byApp,
                                     Boolean bySocial) {
        this.marketingPreferenceId = marketingPreferenceId;
        this.byEmail = byEmail;
        this.byPost = byPost;
        this.byPhone = byPhone;
        this.byText = byText;
        this.byApp = byApp;
        this.bySocial = bySocial;
    }

    public Long getMarketingPreferenceId() {
        return marketingPreferenceId;
    }

    public Boolean getByEmail() {
        return byEmail;
    }

    public void setByEmail(Boolean byEmail) {
        this.byEmail = byEmail;
    }

    public Boolean getByPost() {
        return byPost;
    }

    public void setByPost(Boolean byPost) {
        this.byPost = byPost;
    }

    public Boolean getByPhone() {
        return byPhone;
    }

    public void setByPhone(Boolean byPhone) {
        this.byPhone = byPhone;
    }

    public Boolean getByText() {
        return byText;
    }

    public void setByText(Boolean byText) {
        this.byText = byText;
    }

    public Boolean getByApp() {
        return byApp;
    }

    public void setByApp(Boolean byApp) {
        this.byApp = byApp;
    }

    public Boolean getBySocial() {
        return bySocial;
    }

    public void setBySocial(Boolean bySocial) {
        this.bySocial = bySocial;
    }

    @Override
    public String toString() {
        return "MarketingPreferenceDetail{" +
                "marketingPreferenceId=" + marketingPreferenceId +
                ", byEmail=" + byEmail +
                ", byPost=" + byPost +
                ", byPhone=" + byPhone +
                ", byText=" + byText +
                ", byApp=" + byApp +
                ", bySocial=" + bySocial +
                '}';
    }
}
