package pl.vrum.Corkboard.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.vrum.Corkboard.Model.User;
import pl.vrum.Corkboard.Service.UserService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;


@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> create(@RequestBody @Valid @NotNull User user){
        service.create(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public User getByUsername(@PathVariable("username") String username) {
        return service.find(username);
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody User user, @PathVariable("username") String username) {
        service.update(user, username);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value="/{username}", method = RequestMethod.DELETE)
    public ResponseEntity<User> delete(@PathVariable("username") String username){
        User user = service.find(username);
        if(user==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.delete(user);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

}
