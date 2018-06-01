package pl.vrum.Corkboard.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.vrum.Corkboard.Model.Category;

public interface CategoryRepository  extends JpaRepository<Category, Long> {
}
