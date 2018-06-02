package pl.vrum.Corkboard.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.vrum.Corkboard.Model.Add;

import java.util.List;


public interface AddRepository extends JpaRepository<Add, Long> {

    Add findById(long id);

    @Query
    Iterable<Add> findAllByActiveTrue();

}
