package net.restfulapi.springbootcrud.controller;

import net.restfulapi.springbootcrud.config.JwtTokenUtil;
import net.restfulapi.springbootcrud.model.UserRole;
import net.restfulapi.springbootcrud.repository.RoleRepository;
import net.restfulapi.springbootcrud.repository.UserRepository;
import net.restfulapi.springbootcrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class UserLoginController {

    @Autowired
    private UserService userService;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> loginUser(@Valid @RequestBody UserRole userRole, String username) throws IOException {
        return userService.loginUser(userRole, username);
    }
}


