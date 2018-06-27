package pl.vrum.Corkboard.Service;

import pl.vrum.Corkboard.Model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    void create (User user);

    void delete(User user);

    User find(String username);

    void update(User user, String username);

}
