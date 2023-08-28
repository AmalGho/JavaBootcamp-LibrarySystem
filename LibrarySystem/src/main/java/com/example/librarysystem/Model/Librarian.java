package com.example.librarysystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Librarian {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "name should not be empty")
    @Length(min = 4, message = "name length should be more than 3 characters")
    @Column(columnDefinition = "varchar(10) not null check (name > 3)")
    private String name;

    @NotEmpty(message = "username should not be empty")
    @Length(min = 5, message = "name length should be more than 4 characters")
    @Column(columnDefinition = "varchar(10) not null unique check (name > 4)")
    private String username;

    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "enter strong password!!")
    private String password;

    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
    @Column(columnDefinition = "varchar(50) unique")
    private String email;
}
