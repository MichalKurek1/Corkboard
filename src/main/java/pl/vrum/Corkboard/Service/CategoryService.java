package pl.vrum.Corkboard.Service;

import pl.vrum.Corkboard.Model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();

    void create(Category category);

    void delete(long id);

    Category find(long id);

    void update(Category category, long id);
}
