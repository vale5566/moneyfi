package de.moneyfi.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
@RequestMapping("/user")
public class UserRequest {
    @Autowired
    private UserRepository userRepository;
    @GetMapping(path="/add")
    public User addNewUser (@RequestParam int id, @RequestParam String name, @RequestParam String hashpassword) {
        User n = new User();
        n.setId(id);
        n.setName(name);
        n.setHashpassword(hashpassword);
        userRepository.save(n);
        return n;
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }
}