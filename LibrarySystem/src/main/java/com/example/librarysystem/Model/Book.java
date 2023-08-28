package com.example.librarysystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "book title should not be empty")
    @Length(max = 30, message = "book title length should not be more than 30 characters")
    @Column(columnDefinition = "varchar(30) not null")
    private String title;

    @NotEmpty(message = "book author should not be empty")
    @Length(max = 20, message = "book author length should not be more than 20 characters")
    @Column(columnDefinition = "varchar(20) not null")
    private String author;

    @Column(columnDefinition = "varchar(10) check (category = \"Academic\" or category = \"Mystery\" or category = \"Novel\")")
    @Pattern(regexp = "\\W*((?i)Academic|Mystery|Novel(?-i))\\W*", message = "category not available in the library")
    private String category;

    @NotNull(message = "ISBN should not be empty")
    @Column(columnDefinition = "int not null")
    private Integer isbn;

    @Min(value = 50, message = "number of page must be 50 pages and more")
    @Column(columnDefinition = "int check (numberOfPages >= 50)")
    private Integer numberOfPages;
}
