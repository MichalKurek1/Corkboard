package pl.vrum.Corkboard.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "category")
    @JsonBackReference
    private List<Add> adds;

    public Category() {
    }

    public Category(List<Add> adds) {
        this.adds = adds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Add> getAdds() {
        return adds;
    }

    public void setAdds(List<Add> adds) {
        this.adds = adds;
    }
}
