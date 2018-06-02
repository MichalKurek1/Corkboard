package pl.vrum.Corkboard.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.vrum.Corkboard.Model.Category;
import pl.vrum.Corkboard.Repositories.CategoryRepository;

@CrossOrigin
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping
    public Iterable<Category> allCategories(){
        Iterable<Category> list = categoryRepository.findAll();
        return list;
    }

    @GetMapping("/{id}")
    public Category category(@PathVariable long id){
        return categoryRepository.findById(id);
    }

    @PostMapping
    public Category categoryAdd(@ModelAttribute("category") Category category){
        categoryRepository.save(category);
        return category;
    }

    @PutMapping(value = "/{id}")
    public Category update(@RequestBody Category category, @PathVariable Long id ){
        category.setId(id);
        categoryRepository.save(category);
        return category;
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id){
        categoryRepository.deleteById(id);
    }

}