package net.restfulapi.springbootcrud.dto;

import org.springframework.security.core.parameters.P;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {

    private int id;
    private String username;
    private String email;
    private String password;
    List<String> userDTOList = new ArrayList<>();

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

    public List<String> getUserDTOList() {
        return userDTOList;
    }

    public void setUserDTOList(List<String> userDTOList) {
        this.userDTOList = userDTOList;
    }



}
