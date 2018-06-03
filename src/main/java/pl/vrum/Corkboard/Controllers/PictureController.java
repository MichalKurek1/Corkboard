package pl.vrum.Corkboard.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.vrum.Corkboard.Model.Picture;
import pl.vrum.Corkboard.Repositories.PictureRepository;

import java.io.IOException;

//Controller for tests

@CrossOrigin
@RestController
@RequestMapping("/pictures")
public class PictureController {

    @Autowired
    PictureRepository pictureRepository;

    @PostMapping
    public String uploadFile(
            @RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "unable to upload";
        }try {
            byte[] bytes = file.getBytes();
            Picture picture = new Picture();
            picture.setImage(bytes);
            pictureRepository.save(picture);
        } catch (IOException e) {
            return "Error";
        }
        return "Success";
    }

    @GetMapping("/{id}")
    public Picture sendFile(@PathVariable long id) {
        return pictureRepository.findById(id);
    }

}
