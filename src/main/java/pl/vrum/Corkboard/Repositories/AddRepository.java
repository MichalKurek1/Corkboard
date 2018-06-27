package pl.vrum.Corkboard.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.vrum.Corkboard.Model.Add;

public interface AddRepository extends JpaRepository<Add, Long> {

    @Query("SELECT a FROM Add a WHERE a.id = id")
    Add find(Long id);

    Add findById(long id);

    Iterable<Add> findAllByActiveTrue();

    Iterable<Add> findAllByActiveTrueAndCategory_Id(Long id);

    @Override
    void deleteById(Long id);
}
