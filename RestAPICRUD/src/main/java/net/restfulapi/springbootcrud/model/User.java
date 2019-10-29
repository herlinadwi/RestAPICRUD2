package net.restfulapi.springbootcrud.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "USER")
@Table(name = "users", //
        uniqueConstraints = { //
                @UniqueConstraint(name = "username", columnNames = "username") })
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "users_id", nullable = false)
    private int id;

    @NotNull
    @Size(max = 50)
    @Column(unique = true)
    private String username;

    @NotNull
    @Size(max = 50)
    private String email;

    @NotNull
    @Size(max = 15)
    private String password;

    @ElementCollection
    private List<String> roles = new ArrayList<>();

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

}



    //Komen Sementara

/*    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "user_roles", joinColumns = {
            @JoinColumn(name = "user_id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "roles_id")
            })
    private Set<Role> roles = new HashSet<>();


    public User(){ }

    public User(String username, String email, String password){
        this.username = username;
        this.email = email;
        this.password = password;
    }*/


