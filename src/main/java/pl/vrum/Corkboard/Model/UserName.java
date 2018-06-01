package pl.vrum.Corkboard.Model;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "users")
public class UserName {

    @Id
    @NotBlank(message = "Podaj nazwę użytkownika")
    @Column(unique = true)
    private String username;
    @NotBlank(message = "Enter your first name")
    private String firstName;
    @NotBlank(message = "Enter your last name")
    private String lastName;
    @NotBlank(message = "Enter your email")
    @Email(message = "Invalid email")
    @Column(unique = true)
    private String email;

    @OneToMany(mappedBy = "username")
    @JsonBackReference
    private List<Add> adds;

    public UserName() {
    }

    public UserName(@NotBlank(message = "Podaj nazwę użytkownika") String username, @NotBlank(message = "Enter your first name") String firstName, @NotBlank(message = "Enter your last name") String lastName, @NotBlank(message = "Enter your email") @Email(message = "Invalid email") String email, List<Add> adds) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.adds = adds;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Add> getAdds() {
        return adds;
    }

    public void setAdds(List<Add> adds) {
        this.adds = adds;
    }
}

