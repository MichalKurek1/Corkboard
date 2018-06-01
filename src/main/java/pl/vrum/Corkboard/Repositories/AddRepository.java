package pl.vrum.Corkboard.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.vrum.Corkboard.Model.Add;


public interface AddRepository extends JpaRepository<Add, Long> {

    Add findById(long id);

}
