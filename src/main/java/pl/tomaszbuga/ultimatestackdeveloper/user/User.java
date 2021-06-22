package pl.tomaszbuga.ultimatestackdeveloper.user;

import javax.persistence.*;

@Entity
@Table(name = "user", schema = "public")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(
            name = "username",
            nullable = false)
    private String username;
    @Column(
            name = "password",
            nullable = false)
    private String password;
    @Column(
            name = "role",
            nullable = false)
    private String role;
    @Column(
            name = "email",
            nullable = false)
    private  String email;

    public User() {
    }

    public Long getId() {
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
