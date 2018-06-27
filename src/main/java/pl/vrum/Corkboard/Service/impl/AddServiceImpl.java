package pl.vrum.Corkboard.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.vrum.Corkboard.Model.Add;
import pl.vrum.Corkboard.Repositories.AddRepository;
import pl.vrum.Corkboard.Service.AddService;

import java.util.List;


@Service
public class AddServiceImpl implements AddService {

    @Autowired
    AddRepository repository;


    @Override
    public List<Add> findAll() {
       return repository.findAll();
    }

    @Override
    public void create(Add add) {
        repository.save(add);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Add find(long id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<Add> findAllByActiveTrueAndCategory_Id(Long categoryId) {
        return repository.findAllByActiveTrueAndCategory_Id(categoryId);
    }

    @Override
    public void update(Add add, Long id) {
        Add addToEdit = repository.find(id);
        if(addToEdit != null){
            addToEdit.setImage(add.getImage());
            addToEdit.setCategory(add.getCategory());
            addToEdit.setUsername(add.getUsername());
            addToEdit.setTitle(add.getTitle());
            addToEdit.setShortDescription(add.getShortDescription());
            addToEdit.setFullDescription(add.getFullDescription());
            addToEdit.setPrice(add.getPrice());
            addToEdit.setNumber(add.getNumber());
            repository.save(addToEdit);
        }
    }
}
