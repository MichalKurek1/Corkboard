package pl.vrum.Corkboard.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.vrum.Corkboard.Model.Picture;


public interface PictureRepository extends JpaRepository<Picture, Long> {

    Picture findById(long id);

}
