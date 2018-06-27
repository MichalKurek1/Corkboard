package pl.vrum.Corkboard.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.vrum.Corkboard.Model.Category;
import pl.vrum.Corkboard.Repositories.CategoryRepository;
import pl.vrum.Corkboard.Service.CategoryService;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository repository;

    @Override
    public List<Category> findAll() {
        return repository.findAll();
    }

    @Override
    public Category find(long id) {
        return repository.findById(id);
    }

    @Override
    public void create(Category category) {
        repository.save(category);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }

    @Override
    public void update(Category category, long id) {
        Category categoryToEdit = repository.findById(id);
        if(categoryToEdit != null){
            categoryToEdit.setCategoryName(category.getCategoryName());
            categoryToEdit.setAdds(category.getAdds());
            repository.save(categoryToEdit);
        }
    }
}
