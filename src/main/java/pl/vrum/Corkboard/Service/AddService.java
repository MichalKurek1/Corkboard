package pl.vrum.Corkboard.Service;

import pl.vrum.Corkboard.Model.Add;

import java.util.List;

public interface AddService {

    List<Add> findAll();

    void create (Add add);

    void delete(Long id);

    Add find(long id);

    Iterable<Add> findAllByActiveTrueAndCategory_Id(Long categoryId);

    void update(Add add, Long id);

}
