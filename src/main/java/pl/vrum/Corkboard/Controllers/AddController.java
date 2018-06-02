package pl.vrum.Corkboard.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.vrum.Corkboard.Model.Add;
import pl.vrum.Corkboard.Repositories.AddRepository;


@CrossOrigin
@RestController
@RequestMapping("/adds")
public class AddController {

    @Autowired
    AddRepository addRepository;

    @GetMapping
    public Iterable<Add> allAdds(){
        Iterable<Add> list = addRepository.findAll();
        return list;
    }

    @GetMapping("/{id}")
    public Add add(@PathVariable long id){
        return addRepository.findById(id);
    }

    @PostMapping
    public Add addAdd(@ModelAttribute("add") Add add){
        addRepository.save(add);
        return add;
    }

    @PutMapping(value = "/{id}")
    public Add update (@RequestBody Add add, @PathVariable long id){
        add.setId(id);
        addRepository.save(add);
        return add;
    }

    @DeleteMapping
    public void deleteBook(@PathVariable long id){
        addRepository.deleteById(id);
    }
}
