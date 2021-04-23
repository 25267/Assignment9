package kz.example.controller;

import io.swagger.annotations.Api;
import kz.example.entity.PersonalData;
import kz.example.entity.Role;
import kz.example.entity.User;
import kz.example.repository.PersonalDataRepository;
import kz.example.repository.RoleRepository;
import kz.example.repository.UserRepository;
import kz.example.service.UserService;
import kz.example.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/users")
@Api(value = "User Controller class", description = "This class allows to interact with User object")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping
    public List<User> getALLUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        return userRepository.findById(id).get();
    }


    @PostMapping("/registration")
    public void registration(@RequestBody User user) {
        Role role = roleRepository.findRoleByName("USER");
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());
        newUser.setRoles(Collections.singletonList(role));

        userService.createUser(newUser);
    }


    @PutMapping("/{id}")
    public void updateUser(@PathVariable Long id,
                           @RequestBody User user) {


        userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {

        userRepository.deleteById(id);
    }


}
