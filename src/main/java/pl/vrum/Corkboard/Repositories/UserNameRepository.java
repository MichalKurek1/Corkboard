package pl.vrum.Corkboard.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.vrum.Corkboard.Model.UserName;

public interface UserNameRepository extends JpaRepository<UserName, String> {

    UserName findUserNameByUsername(String username);
}
