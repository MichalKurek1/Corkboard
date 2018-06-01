package pl.vrum.Corkboard.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;


@Entity
@Table(name="adds")
public class Adds {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="category_id")
    @JsonManagedReference
    private Category category;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="username")
    @JsonManagedReference
    private UserName username;

    public Adds() {
    }

    public Adds(Category category, UserName username) {
        this.category = category;
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public UserName getUsername() {
        return username;
    }

    public void setUsername(UserName username) {
        this.username = username;
    }
}