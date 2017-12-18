package financial.firstdigital.online.model;

import javax.persistence.*;

@Entity
@Table(name = "fdf_users")
public class ApplicationUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private long id;

    @Column(name = "user_name")
    private String username; //email and username are synonomoys

    @Column(name = "password")
    private String password;

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
