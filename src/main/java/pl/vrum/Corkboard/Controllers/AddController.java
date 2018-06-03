package pl.vrum.Corkboard.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.vrum.Corkboard.Model.Add;
import pl.vrum.Corkboard.Model.Picture;
import pl.vrum.Corkboard.Repositories.AddRepository;

import java.io.IOException;


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

    @GetMapping("/active/{id}")
    public Iterable<Add> allActiveAdds(@PathVariable long id){
        Iterable<Add> list = addRepository.findAllByActiveTrueAndCategory_Id(id);
        return list;
    }

    @GetMapping("/{id}")
    public Add add(@PathVariable long id){
        return addRepository.findById(id);
    }

    @PostMapping
    public String addAdd(@ModelAttribute("add") Add add, @RequestParam("file") MultipartFile file){

        if (file.isEmpty()) {
            return "unable to upload";
        }try {
            byte[] bytes = file.getBytes();
            add.setImage(bytes);
            addRepository.save(add);
        } catch (IOException e) {
            return "Error";
        }
        return "Success";
    }

    @PutMapping(value = "/{id}")
    public Add update (@RequestBody Add add, @PathVariable long id){
        add.setId(id);
        addRepository.save(add);
        return add;
    }

    @DeleteMapping
    public void deleteAdd(@PathVariable long id){
        addRepository.deleteById(id);
    }
}
