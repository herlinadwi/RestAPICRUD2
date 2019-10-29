package net.restfulapi.springbootcrud.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import net.restfulapi.springbootcrud.exception.ResourceNotFoundException;
import net.restfulapi.springbootcrud.model.*;
import net.restfulapi.springbootcrud.repository.RoleRepository;
import net.restfulapi.springbootcrud.repository.UserRepository;
import net.restfulapi.springbootcrud.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.*;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    PasswordEncoder encoder;

    public ResponseEntity<Map<String, Object>>loginUser(UserRole userRole, String username) throws IOException {
        String token = null;
        UserRole usersRole = userRoleRepository.findByRoleAndUser(username);
        System.out.println(">>>>>>>>> USER ROLE " +usersRole);
        Map<String, Object> tokenMap = new HashMap<String, Object>();
        if(usersRole != null && usersRole.getUser().getUsername().equals(username)){
            token = Jwts.builder().setSubject(username)
                    .claim("roles", userRole.getRole().getName()).setIssuedAt(new Date())
                    .signWith(SignatureAlgorithm.HS256, "secretkey").compact();
            tokenMap.put("token", token);
            tokenMap.put("user", usersRole);
            return new ResponseEntity<Map<String, Object>>(tokenMap, HttpStatus.OK);
        }else{
            tokenMap.put("token", null);
            return new ResponseEntity<Map<String, Object>>(tokenMap, HttpStatus.UNAUTHORIZED);
        }
    }

    public ResponseEntity<User> createUser(UserRole userRole) {
        Optional<User> users = userRepository.findByUsername(userRole.getUser().getUsername());
        System.out.println(">>>>>>>> USERS " +users);
        if (users == null) {
            throw new UsernameNotFoundException("Username Not Found in Databases");
        }
        System.out.println("Found User " + users);
        User user = new User();
        user.setUsername(userRole.getUser().getUsername());
        user.setEmail(userRole.getUser().getEmail());
        user.setPassword(encoder.encode(userRole.getUser().getPassword()));
        List<String> roles = new ArrayList<>();
        roles.add("ADMIN");
        user.setRoles(roles);
        return new ResponseEntity<User>(userRepository.save(user), HttpStatus.CREATED);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public ResponseEntity<User> getUserById(Integer id) throws ResourceNotFoundException {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));
        return ResponseEntity.ok().body(user);
    }

    @Override
    public ResponseEntity<User> updateUser(Integer id, User userDetails) throws ResourceNotFoundException {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));

        user.setUsername(userDetails.getUsername());
        user.setEmail(userDetails.getEmail());
        user.setPassword(userDetails.getPassword());
        final User updatedUser = userRepository.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    @Override
    public Map<String, Boolean> deleteUser(Integer id) throws ResourceNotFoundException {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));

        userRepository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
