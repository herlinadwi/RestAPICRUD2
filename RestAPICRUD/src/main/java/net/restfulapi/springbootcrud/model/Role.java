package net.restfulapi.springbootcrud.model;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "ROLE")
@Table(name = "roles", //
        uniqueConstraints = { //
                @UniqueConstraint(name = "role_name", columnNames = "name") })
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id", nullable = false)
    private int Id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    public int getId(){
        return this.Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
