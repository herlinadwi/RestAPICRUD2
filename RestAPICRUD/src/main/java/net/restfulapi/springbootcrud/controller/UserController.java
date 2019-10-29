package net.restfulapi.springbootcrud.controller;

import net.restfulapi.springbootcrud.config.JwtTokenUtil;
import net.restfulapi.springbootcrud.exception.ResourceNotFoundException;
import net.restfulapi.springbootcrud.model.*;
import net.restfulapi.springbootcrud.repository.UserRepository;
import net.restfulapi.springbootcrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    //Find All
    @GetMapping("/user")
    public List<User> findAll(){
        System.out.println("berhasil masuk");
        return userService.getAllUser();
    }

   //Save
    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public SignUpForm createUser(@Valid @RequestBody UserRole userRole) {

       SignUpForm signUpForm = new SignUpForm();
       signUpForm.setUsername(userRole.getUser().getUsername());
       signUpForm.setEmail(userRole.getUser().getEmail());
       signUpForm.setPassword(userRole.getUser().getPassword());
       signUpForm.setRole(userRole.getRole().getName());
       try{
           userService.createUser(userRole);
       }catch(Exception e){
           System.out.println(">>>>>>>>>>>> GAGAL " +e.getMessage());
       }
       return signUpForm;
    }

    //Edit
    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser(
            @PathVariable(value = "id") Integer id,
            @Valid @RequestBody(required = false) User userDetails) throws ResourceNotFoundException {
        ResponseEntity<User> response = userService.updateUser(id, userDetails);
        return response;
    }

    //Delete
    @DeleteMapping("/user/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException{
        Map<String, Boolean> response = userService.deleteUser(id);
        return response;
    }

    //Find By Id
    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(
            @PathVariable(value = "id") Integer id)throws ResourceNotFoundException{
        ResponseEntity<User> response = userService.getUserById(id);
        return response;
    }
}
