package io.spring.start.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.List;

@Entity

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Size(min=2,max=20,message = "The name must be at least 2 letters and maximam 20 letters")
    @NotBlank(message = "The name must not be blank")
    private String name;
    private String bio;
    @Email(message = "invalid email format")
    @NotBlank
    private String email;
    @Size(min = 8,message = "password must be at least 8 charcters")
    @NotBlank
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,}",message = "password must contain capital character and spechial sympole and at least 8 charcter long")
    private String password;

    private int followers;
    private int following;
    private int postnum;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Post> posts;
}