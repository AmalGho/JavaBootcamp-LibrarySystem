package com.example.librarysystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String author;

    @Column(columnDefinition = "varchar(10) check (category = \"Academic\" or category = \"Mystery\" or category = \"Novel\")")
    @Pattern(regexp = "\\W*((?i)Academic|Mystery|Novel(?-i))\\W*", message = "category not available in the library")
    private String category;
    private Integer isbn;

    @Min(value = 50, message = "number of page must be 50 pages and more")
    private Integer numberOfPages;
}
