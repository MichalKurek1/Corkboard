package pl.vrum.Corkboard.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.vrum.Corkboard.Model.Add;
import pl.vrum.Corkboard.Service.AddService;

import java.io.IOException;


@CrossOrigin
@RestController
@RequestMapping("/adds")
public class AddController {

    @Autowired
    AddService service;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Add> allAdds(){
        Iterable<Add> list = service.findAll();
        return list;
    }

    @RequestMapping(value = "/active/{categoryId}", method = RequestMethod.GET)
    public Iterable<Add> allActiveAdds(@PathVariable Long categoryId){
        Iterable<Add> list = service.findAllByActiveTrueAndCategory_Id(categoryId);
        return list;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Add add(@PathVariable Long id){
        return service.find(id);
    }

    @RequestMapping(value="/protected/post", method=RequestMethod.POST)
    public ResponseEntity<Void> addAdd(@ModelAttribute("add") Add add, @RequestParam("file") MultipartFile file){

        if (file.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }try {
            byte[] bytes = file.getBytes();
            add.setImage(bytes);
            service.create(add);
        } catch (IOException e) {
            new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/protected/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody Add add, @PathVariable Long id){
        service.update(add, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/protected/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Add> deleteAdd(@PathVariable Long id){
        Add add = service.find(id);
        if(add==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.delete(id);
        return new ResponseEntity<>(add,HttpStatus.OK);
    }
}

