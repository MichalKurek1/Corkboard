package pl.vrum.Corkboard.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.vrum.Corkboard.Model.User;


public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByUsername(String username);

}
