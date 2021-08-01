package pl.tomaszbuga.ultimatestackdeveloper.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
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
}
