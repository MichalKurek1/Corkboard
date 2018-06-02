package pl.vrum.Corkboard.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.vrum.Corkboard.Model.UserName;
import pl.vrum.Corkboard.Repositories.UserNameRepository;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserNameController {

    @Autowired
    UserNameRepository userNameRepository;

    @GetMapping
    public Iterable<UserName> allUsers(){
        Iterable<UserName> list = userNameRepository.findAll();
        return list;
    }

    @GetMapping("/{username}")
    public UserName userName(@PathVariable String username) {
        return userNameRepository.findUserNameByUsername(username);
    }

    @PostMapping
    public UserName userNameAdd(@ModelAttribute("username") UserName userName) {
        userNameRepository.save(userName);
        return userName;
    }

    @PutMapping
    public UserName update(@RequestBody UserName userName) {
        userNameRepository.save(userName);
        return userName;
    }

    @DeleteMapping("/{username}")
    public void deleteUserName(@PathVariable String username) {
        userNameRepository.deleteById(username);
    }

}
