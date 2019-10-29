package net.restfulapi.springbootcrud.service;

import net.restfulapi.springbootcrud.exception.ResourceNotFoundException;
import net.restfulapi.springbootcrud.model.*;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface UserService {


    /*public APIResponse login(LoginRequest loginRequest);*/
    ResponseEntity<Map<String, Object>>loginUser(UserRole userRole, String username) throws IOException;
    List<User> getAllUser();
    ResponseEntity<User> getUserById(Integer id) throws ResourceNotFoundException;
    public ResponseEntity<User> createUser(UserRole userRole);
    ResponseEntity<User> updateUser(Integer id, User userDetails) throws ResourceNotFoundException;
    Map<String, Boolean> deleteUser(Integer id) throws ResourceNotFoundException;


}
