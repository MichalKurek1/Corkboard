package pl.vrum.Corkboard.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.vrum.Corkboard.Model.User;
import pl.vrum.Corkboard.Repositories.UserRepository;
import pl.vrum.Corkboard.Service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void create(User user) {
        repository.save(user);
    }

    @Override
    public void delete(User user) {
        repository.delete(user);
    }

    @Override
    public User find(String username) {
        return repository.findUserByUsername(username);
    }

    @Override
    public void update(User user, String username) {

       User userToEdit = repository.findUserByUsername(username);

       if(userToEdit!=null){
            userToEdit.setFirstName(user.getFirstName());
            userToEdit.setLastName(user.getLastName());
            userToEdit.setEmail(user.getEmail());
            userToEdit.setAdds(user.getAdds());
            repository.save(userToEdit)
            ;}
    }

}
